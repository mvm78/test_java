package test_java.tiles;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.lang.reflect.Method;
import java.util.stream.*;

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
    protected String window;
    protected String [] fields;
    protected String [] filters;
    protected LinkedHashMap<String, HashMap<String, Object>> filterColumns;
    protected LinkedHashMap<String, HashMap<String, Object>> columns;
    protected String splitChar = " ";
    protected byte columnIncrement = 1;

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
    public HashMap<String, HashMap<String, Object>> test(HashMap<String, Object> data) {

        Report report = (Report)data.get("report");
        String cmd = data.get("cmd") == null ? report.getCmd() :
                (String)data.get("cmd");
        String filter = (String)data.get("filter");
        int drillLevel = (int)data.get("drillLevel");
        String parentLine = data.get("parentLine") == null ? "" :
                (String)data.get("parentLine");
        boolean isSingleDrill = data.get("isSingleDrill") == null ? false :
                (boolean)data.get("isSingleDrill");

        if (parentLine.isEmpty() && drillLevel == 1) {
            report.resetSkipTiles();
        }

        this.errorTitle = filter.isEmpty() || drillLevel == 1 ?
                this.getTitle() + ":" :
                this.getTitle() + " with filter: " + filter;

        HashMap<String, HashMap<String, Object>> testResults = new HashMap<>();
        AtomicReference<HashMap<String, Object>> tally = new AtomicReference<>(new HashMap<>());
        AtomicInteger lineCount = new AtomicInteger(0);
        AtomicBoolean isLineMatch = new AtomicBoolean(false);

        String [] splitParent = Util.split(parentLine, this.splitChar);
        // "isTileSingleLine" will always be false if "isSingleDrill" is set to
        // true, otherwise refer to this.isSingleLine value
        boolean isTileSingleLine = ! isSingleDrill && this.isSingleLine;

        HashMap<String, Object> params = (HashMap<String, Object>)data.clone();

        params.put("splitParent", splitParent);
        params.put("isSingleDrill", isSingleDrill);
        params.put("parentLine", parentLine);

        for (int filterCount=0; filterCount<this.fields.length; filterCount++) {

            AtomicBoolean isBreak = new AtomicBoolean(false);
            String finalCmd = cmd + this.getQuerySuffix(filter, filterCount);

            Util.debugOutput(this, finalCmd, parentLine);

            params.put("parentLines", this.getParentLines(finalCmd));
            params.put("filterCount", filterCount);

            try (BufferedReader results = this.getQueryResults(finalCmd)) {
                results.lines()
                        .filter(line -> getBufferLineFilter(line))
                        .forEach(line -> {
                            if (! isBreak.get()) {

                                lineCount.incrementAndGet();

                                params.put("line", line.trim());
                                params.put("isLineMatch", isLineMatch.get());
                                params.put("tally", tally.get());

                                HashMap<String, Object> result = this.handleTestBufferLine(params);

                                isBreak.set(isBreak.get() || (boolean)result.get("break"));
                                isLineMatch.set((boolean)result.get("isLineMatch"));
                                tally.set((HashMap<String, Object>)result.get("tally"));
                            }
                        });
            } catch (IOException e) {
                System.err.println(Consts.BRIGHT_RED + "Error reading query file");
                System.exit(1);
            }
        }

        if (! isSingleDrill) {
            // do not need to tally if drilling on a field
            testResults.put("tally", tally.get());
        }

        if (! parentLine.isEmpty()) {
            // output drill errors if any
            if (lineCount.get() == 0) {

                boolean isOutput = true;

                this.lineErrors(null, splitParent, isOutput);
            } else if (! isTileSingleLine && ! isLineMatch.get()) {

                String lineErrorCaption = this.getLineErrorCaption(splitParent);

                this.logError("\t" + lineErrorCaption + ":\n\t\tNO MATCH FOUND");
            }
        }

        return testResults;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillTile(HashMap<String, Object> data) {

        Report report = (Report)data.get("report");
        String line = (String)data.get("line");
        String [] split = (String [])data.get("split");
        String filter = (String)data.get("filter");
        int filterCount = (int)data.get("filterCount");
        int drillLevel = (int)data.get("drillLevel");

        HashMap<String, Object> drillFilter = this.getDrillFilter(new HashMap<String, Object>() {{
            put("report", report);
            put("split", split);
            put("filterCount", filterCount);
            put("filter", filter);
        }});

        String finalFilter = (String)drillFilter.get("finalFilter");

        HashMap<String, Object> params = (HashMap<String, Object>)data.clone();

        params.remove("split");
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
    private void drillField(HashMap<String, Object> data) {

        Report report = (Report)data.get("report");
        String line = (String)data.get("line");
        String [] split = (String [])data.get("split");
        String filter = (String)data.get("filter");
        int filterCount = (int)data.get("filterCount");

        this.columns.values().forEach((values) -> {

            String [] singleDrill = (String [])values.get("singleDrill");

            if (singleDrill == null) {
                return;
            }

            int order = (int)values.get("order");

            HashMap<String, Object> drillFilter = this.getDrillFilter(new HashMap<String, Object>() {{
                put("report", report);
                put("split", split);
                put("filterCount", filterCount);
                put("filter", filter);
                put("singleDrill", order);
            }});

            String finalFilter = (String)drillFilter.get("finalFilter");

            HashMap<String, Object> params = (HashMap<String, Object>)data.clone();

            params.remove("split");
            params.remove("filterCount");
            params.put("filter", finalFilter);
            params.put("parentLine", line);
            params.put("isSingleDrill", true);

            this.test(params);
        });
    }

    //**************************************************************************

    private String getTestCmd(Report report, String line, boolean useReportTime) {

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
            String [] split = Util.split(line, this.splitChar);

            String originalTime = split[order];

            Object index = columnInfo.get("concat");

            if (index != null) {
                originalTime += "." + split[(int)index];
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

    private HashMap<String, Object> tally(String [] split, HashMap<String, Object> tally) {

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

    private HashMap<String, Object> getDrillFilter(HashMap<String, Object> data) {

        Report report = (Report)data.get("report");
        String [] split = (String [])data.get("split");
        String filter = (String)data.get("filter");
        int filterCount = (int)data.get("filterCount");
        int singleDrill = data.get("singleDrill") == null ? 0 :
                (int)data.get("singleDrill");
        String prefixOperator = (String)data.get("prefixOperator");

        AtomicReference<String> rowFilter = new AtomicReference<>("");
        AtomicReference<List<HashMap<String, Object>>> filterInfo =
                new AtomicReference<>(new ArrayList<>());

        String type = singleDrill > 0 ? "singleDrill" : "filter";

        this.columns.forEach((column, info) -> {
            if (info.get(type) == null
             || singleDrill > 0 && (int)info.get("order") != singleDrill) {

                return;
            }

            int count = (int)info.get("order");

            HashMap<String, Object> params = new HashMap<String, Object>() {{
                put("report", report);
                put("filterColumn", column);
                put("value", split[count]);
                put("filterCount", filterCount);
                put("singleDrill", singleDrill);
                put("split", split);
            }};

            String filterField = this.checkIfCustomRowFilter() ?
                    this.getRowFilter(params) :
                    this.common.getCommonRowFilter(params);

            if (! filterField.isEmpty()) {

                List<HashMap<String, Object>> infoValues = filterInfo.get();

                infoValues.add(new HashMap<String, Object>() {{
                    put("column", column);
                    put("order", info.get("order"));
                    put("value", split[count]);
                }});

                filterInfo.set(infoValues);

                String value = rowFilter.get();

                String operator = value.isEmpty() ? "" : " and ";

                rowFilter.set(value + operator + filterField);
            }
        });

        String drillFilter = prefixOperator == null ? rowFilter.toString() :
                prefixOperator + " (" + rowFilter.toString() + ")";

        String finalFilter = filter.isEmpty() ? drillFilter :
                "(" + filter + ") and (" + drillFilter + ")";

        return new HashMap<String, Object>() {{
            put("filterInfo", filterInfo.get());
            put("finalFilter", finalFilter);
        }};
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
                    filter + " w " + this.window;
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

    private List<String []> getParentLines(String finalCmd) {

        List<String []> parentLines = new ArrayList<>();

        try (BufferedReader results = this.getQueryResults(finalCmd)) {
            results.lines()
                    .filter(line -> getBufferLineFilter(line))
                    .forEach(line -> {

                        String [] split = Util.split(line.trim(), this.splitChar);

                        parentLines.add(split);
                    });
        } catch (IOException e) {
            System.err.println(Consts.BRIGHT_RED + "Error reading query file");
            System.exit(1);
        }

        return parentLines;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillFieldNot(HashMap<String, Object> data) {

        String cmd = (String)data.get("cmd");
        ArrayList<String []> parentLines = (ArrayList<String []>)data.get("parentLines");
        String parentLine = data.get("line") == null ? "" : (String)data.get("line");
        int filterCount = (int)data.get("filterCount");

        data.put("prefixOperator", "not");

        HashMap<String, Object> drillFilter = this.getDrillFilter(data);

        String finalFilter = (String)drillFilter.get("finalFilter");
        List<HashMap<String, Object>> filterInfo =
                (List<HashMap<String, Object>>)drillFilter.get("filterInfo");

        String suffix = "when '" + finalFilter + "' filter is applied";

        List<String []> clonedParentLines = parentLines.stream()
                .filter(values -> this.getFilterInfoCount(filterInfo, values) == 0)
                .collect(Collectors.toList());

        String finalCmd = cmd + this.getQuerySuffix(finalFilter, filterCount);

        Util.debugOutput(this, finalCmd, parentLine);

        try (BufferedReader results = this.getQueryResults(finalCmd)) {
            results.lines()
                    .filter(line -> getBufferLineFilter(line))
                    .forEach(line -> {

                        String [] split = Util.split(line.trim(), this.splitChar);

                        int size = clonedParentLines.size();

                        clonedParentLines.removeIf(value -> Arrays.equals(value, split));

                        if (clonedParentLines.size() == size) {
                            // no line was found and removed
                            long duplicateCount = this.getFilterInfoCount(filterInfo, split);

                            if (filterInfo.size() == duplicateCount) {
                                this.logError("\tLine should not exist " + suffix + "\n\t\t" + line);
                            }
                        }
                    });
        } catch (IOException e) {
            System.err.println(Consts.BRIGHT_RED + "Error reading query file");
            System.exit(1);
        }

        if (! clonedParentLines.isEmpty()) {

            this.logError("\tRemaining lines mismatch " + suffix);

            clonedParentLines.stream()
                    .forEach(values -> {
                        this.logError("\t\t" + String.join(this.splitChar, values));
                    });
        }
    }

    //**************************************************************************

    private long getFilterInfoCount(List<HashMap<String, Object>> info, String [] values) {

        return info.stream()
            .filter(infoData -> {

                int order = (int)infoData.get("order");
                String filter = (String)infoData.get("value");

                return filter.equals(values[order]);
            })
            .count();
    }

    //**************************************************************************

    private boolean getBufferLineFilter(String line) {

        line = line.trim();

        return ! line.trim().substring(0, 3).equals("#I;")
            && ! line.trim().substring(0, 6).equals("window");
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private HashMap<String, Object> handleTestBufferLine(HashMap<String, Object> data) {

        String line = (String)data.get("line");
        String parentLine = (String)data.get("parentLine");
        boolean isLineMatch = (boolean)data.get("isLineMatch");
        HashMap<String, Object> tally = (HashMap<String, Object>)data.get("tally");
        boolean isSingleDrill = (boolean)data.get("isSingleDrill");
        String [] splitParent = (String [])data.get("splitParent");
        Report report = (Report)data.get("report");
        int filterCount = (int)data.get("filterCount");
        String filter = (String)data.get("filter");
        int drillLevel = (int)data.get("drillLevel");
        List<String []> parentLines = (List<String []>)data.get("parentLines");

        String [] split = Util.split(line, this.splitChar);

        if (! isSingleDrill) {

            String [] tallyOn = parentLine.isEmpty() ? split : splitParent;

            tally = this.tally(tallyOn, tally);
        }

        final HashMap<String, Object> updatedTally = tally;
        final boolean updatedIsLineMatch = isLineMatch;

        if (! this.checkIsDrillable()) {
            // some tiles like charts or maps may not be subject to drilling
            return new HashMap<String, Object>() {{
                put("tally", updatedTally);
                put("isLineMatch", updatedIsLineMatch);
                put("break", false);
            }};
        }

        if (parentLine.isEmpty() && ! isSingleDrill) {

            String drillFieldCmd = this.getTestCmd(report, line, true);
            String drillTileCmd = this.getTestCmd(report, line, false);
            String paramLine = line;
            int paramFilterCount = filterCount;

            HashMap<String, Object> params = new HashMap<String, Object>() {{
                put("report", report);
                put("cmd", drillFieldCmd);
                put("line", paramLine);
                put("split", split);
                put("filter", filter);
                put("filterCount", paramFilterCount);
                put("drillLevel", drillLevel);
                put("parentLines", parentLines);
            }};

            if (this.checkNot == true) {
                this.drillFieldNot(params);
            }

            params.remove("parentLines");

            this.drillField(params);
            // overwriting "cmd" key with a new value for tile drill
            params.put("cmd", drillTileCmd);

            this.drillTile(params);
        } else {
            // "isTileSingleLine" will always be false if "isSingleDrill" is set
            // to true, otherwise refer to this.isSingleLine value
            boolean isTileSingleLine = ! isSingleDrill && this.isSingleLine;

            final boolean finalIsLineMatch = this.checkLine(new HashMap<String, Object>() {{
                put("splitLine", split);
                put("splitParent", splitParent);
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

}