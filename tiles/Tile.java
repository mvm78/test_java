package test_java.tiles;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.lang.reflect.Method;

import test_java.ErrorsLog;
import test_java.reports.Report;
import test_java.common.Util;
import test_java.common.Consts;
import test_java.tiles.common.Common;
import test_java.tiles.common.CommonBy;

public abstract class Tile {

    protected byte debug = 2;

    private String errorTitle = "";
    protected Common common;
    protected CommonBy commonBy;
    protected boolean isSingleLine = false;
    protected boolean checkNot = true;
    protected String title;
    protected String tileType;
    protected String prefix;
    protected String suffix = "";
    protected String window;
    protected String [] fields;
    protected String [] filters;
    protected LinkedHashMap<String, HashMap<String, Object>> filterColumns;
    protected LinkedHashMap<String, HashMap<String, Object>> columns;
    protected List<String> cellDrillFilters = new LinkedList<>();
    protected String splitChar = " ";
    protected byte columnIncrement = 1;
    protected String lineTally;
    protected boolean removeFirstItem = false;

    //**************************************************************************

    public abstract void setWindow(float timeInterval);

    //**************************************************************************

    protected String getRowFilter(HashMap<String, Object> data) {

        return "";
    }

    //**************************************************************************

    public String getTitle() {

        return this.title;
    }

    //**************************************************************************

    public String getTileType() {

        return this.tileType;
    }

    //**************************************************************************

    public LinkedHashMap<String, HashMap<String, Object>> getColumns() {

        return this.columns;
    }

    //**************************************************************************

    public byte getDebug() {

        return this.debug;
    }

    //**************************************************************************

    public String getSplitChar() {

        return this.splitChar;
    }

    //**************************************************************************

    public String getLineTally() {

        return this.lineTally;
    }

    //**************************************************************************

    public boolean getRemoveFirstItem() {

        return this.removeFirstItem;
    }

    //**************************************************************************

    public BufferedReader getQueryResults(String finalCmd) {

        try (PrintWriter out = new PrintWriter("run_query.sh")) {
            out.println(finalCmd);
        } catch (FileNotFoundException e) {
            System.err.println(Consts.BRIGHT_RED + "File run_query.sh was not found");
            System.exit(1);
        }

        Runtime runtime = Runtime.getRuntime();

        try {

            Process process = runtime.exec("sh run_query.sh");

            InputStream inputStream = process.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader;

        } catch (IOException e) {
            System.err.println(Consts.BRIGHT_RED + "Error running run_query.sh");
            System.exit(1);
        }

        return null;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public Map<String, Map<String, Object>> test(Map<String, Object> data) {

        Report report = (Report)data.get("report");
        String cmd = data.get("cmd") == null ? report.getCmd() : (String)data.get("cmd");
        String filter = (String)data.get("filter");
        int drillLevel = (int)data.get("drillLevel");
        String [] splitParent = data.get("split") == null ? new String [] {} :
                (String [])((String [])data.get("split")).clone();
        boolean isCellDrill = data.get("isCellDrill") == null ? false : (boolean)data.get("isCellDrill");
        int cellDrill = data.get("cellDrill") == null ? 0 : (int)data.get("cellDrill");
        List<String []> parentLines = data.get("parentLines") == null ? null :
                (List<String []>)((ArrayList<String []>)data.get("parentLines")).clone();
        String operator = (String)data.get("operator");

        if (splitParent.length == 0 && drillLevel == 1) {
            report.resetSkipTiles();
        }

        this.errorTitle = filter.isEmpty() || drillLevel == 1 ?
                this.getTitle() + ":" :
                this.getTitle() + " with filter: " + filter;

        AtomicInteger lineCount = new AtomicInteger(0);
        AtomicBoolean isLineMatch = new AtomicBoolean(false);
        AtomicReference<Map<String, Object>> tally =
                new AtomicReference<>(new HashMap<>());
        Map<String, Object> params =
                (Map<String, Object>)((HashMap<String, Object>)data).clone();

        params.put("splitParent", splitParent.clone());
        params.put("isCellDrill", isCellDrill);

        Tile tile = this;

        for (int filterCount=0; filterCount<this.fields.length; filterCount++) {

            String finalCmd = cmd + this.getQuerySuffix(filter, filterCount);

            List<String []> lines = this.getQueryLines(finalCmd);

            Util.debugOutput(new HashMap<String, Object>() {{
                put("tile", tile);
                put("finalCmd", finalCmd);
                put("lines", lines);
                put("parentLine", String.join(tile.getSplitChar(), splitParent));
                put("skipCompare", isCellDrill);
            }});

            if (isCellDrill) {

                this.checkMatchedLines(new HashMap<String, Object>() {{
                    put("parentLines", parentLines);
                    put("lines", lines);
                    put("splitParent", splitParent);
                    put("cellDrill", cellDrill);
                    put("filter", filter);
                    put("operator", operator);
                }});

                continue;
            }

            AtomicBoolean isBreak = new AtomicBoolean(false);

            params.put("filterCount", filterCount);
            params.put("parentLines", lines);

            lines.stream()
                    .filter(line -> ! isBreak.get() && Util.getBufferLineFilter(line))
                    .forEach(line -> {

                        lineCount.incrementAndGet();

                        params.put("split", line);
                        params.put("isLineMatch", isLineMatch.get());
                        params.put("tally", tally.get());

                        Map<String, Object> result = this.handleTestBufferLine(params);

                        isBreak.set((boolean)result.get("break"));
                        isLineMatch.set((boolean)result.get("isLineMatch"));
                        tally.set((HashMap<String, Object>)result.get("tally"));
                    });
        }

        Map<String, Map<String, Object>> testResults = new HashMap<>();

        if (! isCellDrill) {
            // do not need to tally if drilling on a field
            Map<String, Object> drillTally = tally.get();

            if (this.getLineTally() != null) {
                drillTally.put(this.getLineTally(), (double)lineCount.get());
            }

            testResults.put("tally", drillTally);
        }

        if (isCellDrill || splitParent.length == 0) {
            return testResults;
        }

        if (lineCount.get() == 0) {

            boolean isOutput = true;

            this.lineErrors(null, splitParent, isOutput);
        } else if (! this.isSingleLine && ! isLineMatch.get()) {

            String lineErrorCaption = this.getLineErrorCaption(splitParent);

            this.logError("\t" + lineErrorCaption + ":\n\t\tNO MATCH FOUND");
        }

        return testResults;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillTile(Map<String, Object> data) {

        Report report = (Report)data.get("report");
        String line = (String)data.get("line");
        String [] split = (String [])((String [])data.get("split")).clone();
        String filter = (String)data.get("filter");
        int filterCount = (int)data.get("filterCount");
        int drillLevel = (int)data.get("drillLevel");

        String finalFilter = this.getDrillFilter(new HashMap<String, Object>() {{
            put("report", report);
            put("split", split.clone());
            put("filterCount", filterCount);
            put("filter", filter);
        }});

        Map<String, Object> params =
                (Map<String, Object>)((HashMap<String, Object>)data).clone();

        params.remove("splitParent");
        params.remove("filterCount");
        params.put("filter", finalFilter);
        params.put("parentLine", line);

        this.test(params);

        Report drillReport;

        try {
            drillReport = report.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }

        if (drillReport != null) {
            drillReport.addSkipTile(this.getTrueName());
            drillReport.tests(drillLevel + 1, finalFilter);
        }
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillCell(HashMap<String, Object> data) {

        String filter = (String)data.get("filter");

        Map<String, Object> params = (HashMap<String, Object>)data.clone();

        params.put("isCellDrill", true);

        this.columns.values().stream()
                .filter(values -> values.get("cellDrill") != null)
                .forEach(values -> {

                    int order = (int)values.get("order");

                    params.put("cellDrill", order);

                    for (String operator : new String [] {null, "not"}) {
                        if (operator == null && this.isSingleLine
                         && ((String [])values.get("cellDrill")).length == 0) {
                            // skip as row drill will perform the same action as call drill
                            continue;
                        }

                        // have to reset "filter" before passing it to getDrillFilter() method
                        params.put("filter", filter);
                        params.put("operator", operator);

                        String finalFilter = this.getDrillFilter(params);

                        if (this.cellDrillFilters.contains(finalFilter)) {
                            continue;
                        }

                        this.cellDrillFilters.add(finalFilter);

                        params.put("filter", finalFilter);

                        this.test(params);
                    }
                });
    }

    //**************************************************************************

    private String getTestCmd(Report report, String [] split, boolean useReportTime) {

        String beginTime = report.getBeginTime();
        String endTime = report.getEndTime();

        String reportStartTime = Util.getTimeString(beginTime);
        String reportStopTime = Util.getTimeString(endTime);

        if (useReportTime) {
            // using report's original start and stop time
            return report.getCmd(reportStartTime, reportStopTime);
        }

        HashMap<String, String> reportTime = new HashMap<String, String>() {{
            put("startTime", reportStartTime);
            put("stopTime", reportStopTime);
        }};

        this.columns.values().forEach((columnInfo) -> {

            Object startTime = columnInfo.get("startTime");
            Object stopTime = columnInfo.get("stopTime");

            if (startTime == null && stopTime == null) {
                return;
            }

            int order = (int)columnInfo.get("order");
            String timeField = startTime == null ? "stopTime" : "startTime";

            String originalTime = split[order];

            if (originalTime.equals("NA") && this.getTitle().equals("Web Sessions")) {

                originalTime = Long.toString(System.currentTimeMillis() / 1000L);

            } else {

                Object index = columnInfo.get("concat");

                if (index != null) {
                    originalTime += "." + split[(int)index];
                }
            }

            String alteration = columnInfo.get(timeField).toString();

            if (alteration.isEmpty()) {
                reportTime.put(timeField, originalTime);
            } else {

                String adjustedTime = this.getAdjustedTime(alteration, originalTime);

                reportTime.put(timeField, adjustedTime);
            }
        });

        String startTime = reportTime.get("startTime");
        String stopTime = reportTime.get("stopTime");

        return report.getCmd(startTime, stopTime);
    }

    //**************************************************************************

    private String getAdjustedTime(String alteration, String originalTime) {

        String [] timeAlter = alteration.split("\\s+");

        String sign = timeAlter[0];
        int value = Integer.valueOf(timeAlter[1]);
        String measure = timeAlter[2];
        // split time string by "." to seconds and microseconds
        String[] splitTime = originalTime.split("\\.");

        int seconds = Integer.valueOf(splitTime[0]);
        int microSeconds = splitTime.length == 1 ? 0 :
                Math.round(Float.valueOf("0." + splitTime[1]) * 1000000);

        value *= sign.equals("+") ? 1 : -1;

        switch (measure) {
            case "sec":
                seconds += value;
                break;
            case "ms":
                microSeconds += value * 1000;
                break;
            case "μs":
                microSeconds += value;
                break;
            default:
                break;
        }

        Float adjustedMicroSeconds = Float.valueOf(microSeconds) / 1000000;

        String timeSeconds = String.valueOf(seconds);
        String timeMicroSeconds = String.format("%.6f", adjustedMicroSeconds);
        // have to remove "0" before "." when concatenating seconds with microseconds
        String adjustedTime = timeSeconds + timeMicroSeconds.substring(1);

        return adjustedTime;
    }

    //**************************************************************************

    private Map<String, Object> tally(String [] split, Map<String, Object> tally) {

        this.columns.forEach((column, info) -> {

            int count = (Integer)info.get("order");
            Object isTally = info.get("tally");

            if (isTally != null && isTally.toString().equals("true")) {

                Object tallied = tally.get(column);

                tallied = tallied == null ? 0D : tallied;

                tally.put(column, (double)tallied + Double.valueOf(split[count]));
            }
        });

        return tally;
    }

    //**************************************************************************

    private boolean checkLine(HashMap<String, Object> data) {

        String [] splitLine = (String [])data.get("splitLine");
        String [] splitParent = (String [])data.get("splitParent");
        boolean isTileSingleLine = (boolean)data.get("isTileSingleLine");

        if (isTileSingleLine) {
            // there should be only one line on link drill
            if (Arrays.equals(splitLine, splitParent)) {
                return true;
            } else {
                // original (parent) and result (after drill) lines do not match
                boolean isOutput = true;

                this.lineErrors(splitLine, splitParent, isOutput);

                return false;
            }
        } else {
            // there can be many lines on link drill. One of those lines should match
            boolean isOutput = false;

            return this.lineErrors(splitLine, splitParent, isOutput);
        }
    }

    //**************************************************************************

    private boolean checkLines(HashMap<String, Object> data) {

        String [] splitLine = (String [])data.get("splitLine");
        String [] splitParent = (String [])data.get("splitParent");
        boolean isTileSingleLine = (boolean)data.get("isTileSingleLine");

        if (isTileSingleLine) {
            // there should be only one line on link drill
            if (Arrays.equals(splitLine, splitParent)) {
                return true;
            } else {
                // original (parent) and result (after drill) lines do not match
                boolean isOutput = true;

                this.lineErrors(splitLine, splitParent, isOutput);

                return false;
            }
        } else {
            // there can be many lines on link drill. One of those lines should match
            boolean isOutput = false;

            return this.lineErrors(splitLine, splitParent, isOutput);
        }
    }

    //**************************************************************************

    private String getDrillFilter(Map<String, Object> data) {

        Report report = (Report)data.get("report");
        String [] split = (String [])((String [])data.get("split")).clone();
        String filter = (String)data.get("filter");
        int filterCount = (int)data.get("filterCount");
        int cellDrill = data.get("cellDrill") == null ? 0 :
                (int)data.get("cellDrill");
        String operator = (String)data.get("operator");

        AtomicReference<String> rowFilter = new AtomicReference<>("");
        AtomicReference<List<Map<String, Object>>> filterInfo =
                new AtomicReference<>(new ArrayList<>());

        this.columns.entrySet().stream()
                .filter(info -> {

                    int count = (int)info.getValue().get("order");

                    return cellDrill == 0 && info.getValue().get("filter") != null
                        || cellDrill == count && info.getValue().get("cellDrill") != null;
                })
                .forEach(info -> {

                    int count = (int)info.getValue().get("order");

                    HashMap<String, Object> params = new HashMap<String, Object>() {{
                        put("report", report);
                        put("filterColumn", info.getKey());
                        put("value", split[count]);
                        put("filterCount", filterCount);
                        put("cellDrill", cellDrill);
                        put("split", split.clone());
                    }};

                    String filterField = this.checkIfCustomRowFilter() ?
                            this.getRowFilter(params) :
                            this.common.getCommonRowFilter(params);

                    if (! filterField.isEmpty()) {

                        List<Map<String, Object>> infoValues = filterInfo.get();

                        infoValues.add(new HashMap<String, Object>() {{
                            put("column", info.getKey());
                            put("order", info.getValue().get("order"));
                            put("value", split[count]);
                        }});

                        filterInfo.set(infoValues);

                        String value = rowFilter.get();

                        value += value.isEmpty() ? "" : " and ";

                        rowFilter.set(value + filterField);
                    }
        });

        String drillFilter = operator == null ? rowFilter.toString() :
                operator + " (" + rowFilter.toString() + ")";

        return filter.isEmpty() ? drillFilter : "(" + filter + ") and (" + drillFilter + ")";
    }

    //**************************************************************************

    private boolean lineErrors(
            String [] splitLine,
            String [] splitParent,
            boolean isOutput
    ) {

        String lineErrorCaption = this.getLineErrorCaption(splitParent);

        if (splitLine == null || splitLine.length == 0) {
            if (isOutput) {
                this.logError("\t" + lineErrorCaption + ":\n\t\tNO DATA");
            }

            return true;
        }

        AtomicBoolean isTitlePrined = new AtomicBoolean(false);
        AtomicBoolean isError = new AtomicBoolean(false);

        this.columns.forEach((column, info) -> {

            int count = (Integer)info.get("order");

            String parentValue = splitParent[count];
            String drilledValue = splitLine[count];

            Object compare = info.get("compare");
            Object filter = info.get("filter");

            if ((compare != null || filter != null)
             && ! drilledValue.equals(parentValue)) {
                // processing line has mismatch values
                if (! isOutput) {
                    // no output neede, just verifying value pairs
                    isError.set(true);
                    // exit loop if at least one pair of values mismatch
                    return;
                }

                if (compare != null && compare.toString().equals("number")) {

                    double parentDoubleValue = Double.valueOf(parentValue);
                    double drilledDoubleValue = Double.valueOf(drilledValue);

                    parentValue = parentDoubleValue == 0 ? parentValue :
                            Util.getPrettyNumber(parentDoubleValue);
                    drilledValue = parentDoubleValue == 0 ? drilledValue :
                            Util.getPrettyNumber(drilledDoubleValue);
                }

                String error = column + ": " + parentValue + " # " + drilledValue;

                if (! isTitlePrined.getAndSet(true)) {
                    this.logError("\t" + lineErrorCaption + ":");
                }

                this.logError("\t\t" + error);
            }
        });

        return ! isError.get();
    }

    //**************************************************************************

    private String getLineErrorCaption(String [] split) {

        AtomicReference<String> caption = new AtomicReference<>("");

        this.columns.forEach((column, info) -> {
            if (info.get("filter") != null) {

                int count = (Integer)info.get("order");
                String prev = caption.get();

                String comma = prev.isEmpty() ? "" : ", ";

                caption.set(prev + comma + column + " \"" + split[count] + "\"");
            }
        });

        return caption.toString();
    }

    //**************************************************************************

    private String getQuerySuffix(String customFilter, int filterCount) {

        String finalFilter;
        String commonFilter = this.filters.length > 0 ?
                this.filters[filterCount] : "";

        if (customFilter == null || customFilter.isEmpty()) {
            finalFilter = commonFilter;
        } else if (commonFilter.isEmpty()) {
            finalFilter = customFilter;
        } else {
            finalFilter = "(" + customFilter + ") and (" + commonFilter + ")";
        }

        String filter = finalFilter.isEmpty() ? "" : " q '" + finalFilter + "'";

        return " " + this.prefix + " " + this.fields[filterCount] +
                    filter + " " + this.suffix + " w " + this.window;
    }

    //**************************************************************************

    public String getTrueName() {

        String className = this.getClass().getName();

        int start = className.lastIndexOf('.') + 1;

        return className.substring(start);
    }

    //**************************************************************************

    private void logError(String error) {

        ErrorsLog.log(this.errorTitle);

        this.errorTitle = "";

        ErrorsLog.log(error);
    }

    //**************************************************************************

    private boolean checkIsDrillable() {

        if (this.checkIfCustomRowFilter()) {
            return true;
        }

        AtomicBoolean isDrillable = new AtomicBoolean(false);

        this.columns.values().forEach((columnInfo) -> {
            if (isDrillable.get()) {
                // continue the loop if is already drillable
                return;
            }

            if (columnInfo.get("filter") != null) {
                isDrillable.getAndSet(true);
            }
        });

        return (boolean)isDrillable.get();
    }

    //**************************************************************************

    protected final void setCommonData() {

        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns,
                this.columnIncrement);
    }

    //**************************************************************************

    private boolean checkIfCustomRowFilter() {

        Method isCustomRowFilter = null;

        try {
            isCustomRowFilter = this.getClass()
                    .getDeclaredMethod("getRowFilter", HashMap.class);
        } catch (NoSuchMethodException | SecurityException e) {
            // no need to catch errors
        }

        return isCustomRowFilter != null;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private Map<String, Object> handleTestBufferLine(Map<String, Object> data) {

        String [] split = (String [])((String [])data.get("split")).clone();
        boolean isLineMatch = (boolean)data.get("isLineMatch");
        Map<String, Object> tally =
                (Map<String, Object>)((HashMap<String, Object>)data.get("tally")).clone();
        boolean isCellDrill = (boolean)data.get("isCellDrill");
        String [] splitParent = (String [])((String [])data.get("splitParent")).clone();
        Report report = (Report)data.get("report");
        int filterCount = (int)data.get("filterCount");
        String filter = (String)data.get("filter");
        int drillLevel = (int)data.get("drillLevel");
        List<String []> parentLines =
                (List<String []>)((ArrayList<String []>)data.get("parentLines")).clone();

        if (! isCellDrill) {

            String [] tallyOn = splitParent.length > 0 ? splitParent : split;

            tally = this.tally(tallyOn, tally);
        }

        final Map<String, Object> updatedTally =
                (Map<String, Object>)((HashMap<String, Object>)tally).clone();
        final boolean updatedIsLineMatch = isLineMatch;

        if (! this.checkIsDrillable()) {
            // some tiles like charts or maps may not be subject to drilling
            return new HashMap<String, Object>() {{
                put("tally", updatedTally);
                put("isLineMatch", updatedIsLineMatch);
                put("break", false);
            }};
        }

        if (isCellDrill) {

        } else if (splitParent.length == 0) {

            String drillFieldCmd = this.getTestCmd(report, split, true);
            String drillTileCmd = this.getTestCmd(report, split, false);
            int paramFilterCount = filterCount;

            HashMap<String, Object> params = new HashMap<String, Object>() {{
                put("report", report);
                put("cmd", drillFieldCmd);
                put("split", split.clone());
                put("filter", filter);
                put("filterCount", paramFilterCount);
                put("drillLevel", drillLevel);
                put("parentLines", parentLines);
            }};

            this.drillCell(params);
            // overwriting "cmd" key with a new value for tile drill
            params.put("cmd", drillTileCmd);

            this.drillTile(params);
        } else {

            boolean isTileSingleLine = this.isSingleLine;

            final boolean finalIsLineMatch = this.checkLine(new HashMap<String, Object>() {{
                put("splitLine", split.clone());
                put("splitParent", splitParent.clone());
                put("isTileSingleLine", isTileSingleLine);
            }}) || isLineMatch;

            if (! isTileSingleLine && finalIsLineMatch) {
                return new HashMap<String, Object>() {{
                   put("tally", updatedTally);
                   put("isLineMatch", finalIsLineMatch);
                   put("break", true);
               }};
            }
        }

        return new HashMap<String, Object>() {{
            put("tally", updatedTally);
            put("isLineMatch", updatedIsLineMatch);
            put("break", false);
        }};
    }

    //**************************************************************************

    private List<String []> getQueryLines(String finalCmd) {

        List<String []> result = new ArrayList<>();

        try (BufferedReader results = this.getQueryResults(finalCmd)) {
            results.lines()
                    .forEach(line -> {

                        String [] split = Util.split(line.trim(), this.splitChar);

                        if (this.removeFirstItem) {
                            split = Arrays.copyOfRange(split, 1, split.length);
                        }

                        result.add(split);
                    });
        } catch (IOException e) {
            System.err.println(Consts.BRIGHT_RED + "Error reading query file");
            System.exit(1);
        }

        return result;
    }

    //**************************************************************************

    private String getColumnTitle(int order) {

        return this.getColumns().entrySet().stream()
                .filter(item -> (int)item.getValue().get("order") == order)
                .findFirst()
                .get()
                .getKey();
    }

    //**************************************************************************

    private void checkMatchedLines(Map<String, Object> data) {

        String [] splitParent = (String [])((String [])data.get("splitParent")).clone();
        int cellDrill = (int)data.get("cellDrill");
        String filter = (String)data.get("filter");
        String operator = data.get("operator") == null ? "" :
                (String)data.get("operator");

        String parentValue = splitParent[cellDrill];

        Map<String, List<String []>> result = this.getArrayListIntersection(data);

        List<String []> parentLines = (ArrayList<String []>)result.get("parentLines");

        parentLines.stream()
                .filter(line -> {
                    if (! Util.getBufferLineFilter(line)) {
                        return false;
                    } else {
                        // either both (empty and equal) TRUE or both FALSE
                        return operator.isEmpty() == line[cellDrill].equals(parentValue);
                    }
                })
                .forEach(line -> {
                    this.logDrilledColumnError(new HashMap<String, Object>() {{
                        put("message", "is missing");
                        put("filter", filter);
                        put("columnOrder", cellDrill);
                        put("line", line);
                    }});
                });
    }

    //**************************************************************************

    private Map<String, List<String []>> getArrayListIntersection(Map<String, Object> data) {

        List<String []> parentLines =
                (List<String []>)((ArrayList<String []>)data.get("parentLines")).clone();
        List<String []> filteredLines =
                (List<String []>)((ArrayList<String []>)data.get("lines")).clone();
        String [] splitParent = (String [])((String [])data.get("splitParent")).clone();
        int cellDrill = (int)data.get("cellDrill");
        String filter = (String)data.get("filter");
        String operator = data.get("operator") == null ? "" :
                (String)data.get("operator");

        Iterator<String []> filteredIterator = filteredLines.iterator();

        while (filteredIterator.hasNext()) {

            String [] filteredLine = filteredIterator.next();

            if (! Util.getBufferLineFilter(filteredLine)) {

                filteredIterator.remove();

                continue;
            }

            String parentValue = splitParent[cellDrill];
            String filterValue = filteredLine[cellDrill];

            boolean isEqual = parentValue.equals(filterValue);

            if (operator.isEmpty() && ! isEqual || operator.equals("not") && isEqual) {
                this.logDrilledColumnError(new HashMap<String, Object>() {{
                    put("message", "must not have");
                    put("filter", filter);
                    put("columnOrder", cellDrill);
                    put("line", filteredLine);
                }});
            }

            Iterator<String []> parentIterator = parentLines.iterator();

            while (parentIterator.hasNext()) {

                String [] parentLine = parentIterator.next();

                if (! Util.getBufferLineFilter(parentLine)) {

                    parentIterator.remove();

                    continue;
                }

                if (Arrays.equals(filteredLine, parentLine)) {

                    filteredIterator.remove();
                    parentIterator.remove();

                    break;
                }
            }
        }

        return new HashMap<String, List<String []>>() {{
            put("parentLines", parentLines);
            put("filteredLines", filteredLines);
        }};
    }

    //**************************************************************************

    private void logDrilledColumnError(Map<String, Object> data) {

        String message = (String)data.get("message");
        String [] line = (String [])((String [])data.get("line")).clone();
        int columnOrder = (int)data.get("columnOrder");
        String filter = (String)data.get("filter");

        String columnTitle = this.getColumnTitle(columnOrder);

        this.logError("\t" + "Query with applied filter '" + filter +
                "' " + message + " a line with '" + columnTitle + "' = " +
                "\"" + line[columnOrder] + "\":");

        this.logError("\t\t" + String.join(this.getSplitChar(), line));
    }

    //**************************************************************************

}
