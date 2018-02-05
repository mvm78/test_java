package test_java.tiles;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
import java.lang.reflect.Method;

import test_java.ErrorsLog;
import test_java.reports.Report;
import test_java.common.Util;
import test_java.common.Consts;
import test_java.tiles.common.Common;
import test_java.tiles.common.CommonBy;

public class Tile implements Cloneable {

    protected byte debug = 2;

    private Report report;
    private Map<String, String> reportTime;
    private boolean noDrill = false;
    private String errorTitle = "";
    private Common common;
    private CommonBy commonBy;
    private String appPath;
    private boolean isSingleLine = false;
    private String title;
    private String tileType;
    private String prefix;
    private String suffix = "";
    private String window = "0.0";
    private String [] fields;
    private String [] filters;
    private LinkedHashMap<String, HashMap<String, Object>> filterColumns;
    protected LinkedHashMap<String, HashMap<String, Object>> columns;
    protected List<String> cellDrillFilters = new LinkedList<>();
    protected String splitChar = " ";
    protected byte columnIncrement = 1;
    protected String lineTally;
    protected boolean removeFirstItem = false;

    //**************************************************************************

    final public Report getReport() {

        return this.report;
    }

    //**************************************************************************

    final public void setReport(Report report) {

        this.report = report;
    }

    //**************************************************************************

    final public Map<String, String> getReportTime() {

        return this.reportTime;
    }

    //**************************************************************************

    final public void setReportTime(Map<String, String> reportTime) {

        this.reportTime = reportTime;
    }

    //**************************************************************************

    final public boolean getNoDrill() {

        return this.noDrill;
    }

    //**************************************************************************

    final public void setNoDrill(boolean noDrill) {

        this.noDrill = noDrill;
    }

    //**************************************************************************

    final public String getErrorTitle() {

        return this.errorTitle;
    }

    //**************************************************************************

    final public void setErrorTitle(String errorTitle) {

        this.errorTitle = errorTitle;
    }

    //**************************************************************************

    final public Common getCommon() {

        return this.common;
    }

    //**************************************************************************

    final public void setCommon(Common common) {

        this.common = common;
    }

    //**************************************************************************

    final public CommonBy getCommonBy() {

        return this.commonBy;
    }

    //**************************************************************************

    final public void setCommonBy(CommonBy commonBy) {

        this.commonBy = commonBy;
    }

    //**************************************************************************

    final public String getAppPath() {

        return this.appPath;
    }

    //**************************************************************************

    final public void setAppPath(String appPath) {

        this.appPath = appPath;
    }

    //**************************************************************************

    final public boolean getIsSingleLine() {

        return this.isSingleLine;
    }

    //**************************************************************************

    final public void setIsSingleLine(boolean isSingleLine) {

        this.isSingleLine = isSingleLine;
    }

    //**************************************************************************

    final public String getTitle() {

        return this.title;
    }

    //**************************************************************************

    final public void setTitle(String title) {

        this.title = title;
    }

    //**************************************************************************

    final public String getTileType() {

        return this.tileType;
    }

    //**************************************************************************

    final public void setTileType(String tileType) {

        this.tileType = tileType;
    }

    //**************************************************************************

    final public String getPrefix() {

        return this.prefix;
    }

    //**************************************************************************

    final public void setPrefix(String prefix) {

        this.prefix = prefix;
    }

    //**************************************************************************

    final public String getSuffix() {

        return this.suffix;
    }

    //**************************************************************************

    final public void setSuffix(String suffix) {

        this.suffix = suffix;
    }

    //**************************************************************************

    final public String getWindow() {

        return this.window;
    }

    //**************************************************************************

    final public void setWindow(String window) {

        this.window = window;
    }

    //**************************************************************************

    public void setWindow(float window) {

        this.window = String.valueOf(window);
    }

    //**************************************************************************

    final public String [] getFields() {

        return this.fields;
    }

    //**************************************************************************

    final public String getField(int index) {

        return this.getFields()[index];
    }

    //**************************************************************************

    final public void setFields() {

        this.setFields(new String [] {""});
    }

    //**************************************************************************

    final public void setFields(String [] fields) {

        this.fields = fields;
    }

    //**************************************************************************

    final public void setField(int index, String field) {

        this.fields[index] = field;
    }

    //**************************************************************************

    final public String [] getFilters() {

        return this.filters;
    }

    //**************************************************************************

    final public String getFilter(int index) {

        return this.getFilters()[index];
    }

    //**************************************************************************

    final public void setFilters() {

        this.setFilters(new String [] {""});
    }

    //**************************************************************************

    final public void setFilters(String [] filters) {

        this.filters = filters;
    }

    //**************************************************************************

    final public void setFilter(int index, String filter) {

        this.filters[index] = filter;
    }

    //**************************************************************************

    final public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return this.filterColumns;
    }

    //**************************************************************************

    final public void setFilterColumns(LinkedHashMap<String, HashMap<String, Object>> filterColumns) {

        this.filterColumns = filterColumns;
    }

    //**************************************************************************

    @Override
    final public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    //**************************************************************************

    protected String getRowFilter(Map<String, Object> data) {

        return "";
    }

    //**************************************************************************

    final public LinkedHashMap<String, HashMap<String, Object>> getColumns() {

        return this.columns;
    }

    //**************************************************************************

    final public byte getDebug() {

        return this.debug;
    }

    //**************************************************************************

    final public String getSplitChar() {

        return this.splitChar;
    }

    //**************************************************************************

    final public String getLineTally() {

        return this.lineTally;
    }

    //**************************************************************************

    final public boolean getRemoveFirstItem() {

        return this.removeFirstItem;
    }

    //**************************************************************************

    final public String getCommonByClassName() {

        return this.getCommonBy() == null ? "" :
                this.getCommonBy().getClass().getName();
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private Tile cloneTile() {

        Tile tile = null;

        try {
            tile = (Tile)this.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println(Consts.BRIGHT_RED + "Error cloning tile");
            System.exit(1);
        }

        if (tile == null) {
            System.err.println(Consts.BRIGHT_RED + "Error cloning tile");
            System.exit(1);
        }

        return tile;
    }

    //**************************************************************************

    public BufferedReader getQueryResults(String finalCmd) {

        String shellFile = "run_query-" + UUID.randomUUID().toString() + ".sh";

        try (PrintWriter out = new PrintWriter(shellFile)) {
            out.println(finalCmd);
        } catch (FileNotFoundException e) {
            System.err.println(Consts.BRIGHT_RED + "File " + shellFile + " was not found");
            System.exit(1);
        }

        Runtime runtime = Runtime.getRuntime();

        try {

            Process process = runtime.exec("sh " + shellFile);

            InputStream inputStream = process.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader;

        } catch (IOException e) {
            System.err.println(Consts.BRIGHT_RED + "Error running " + shellFile);
            System.exit(1);
        }

        return null;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public Map<String, Map<String, Object>> test(Map<String, Object> data) {

        String cmd = data.get("cmd") == null ? this.getReport().getCmd(this) :
                (String)data.get("cmd");
        String filter = (String)data.get("filter");
        int drillLevel = (int)data.get("drillLevel");
        String [] splitParent = data.get("split") == null ? new String [] {} :
                (String [])((String [])data.get("split")).clone();
        boolean isCellDrill = data.get("isCellDrill") == null ? false :
                (boolean)data.get("isCellDrill");
        int cellDrill = data.get("cellDrill") == null ? 0 : (int)data.get("cellDrill");
        List<String []> parentLines = data.get("parentLines") == null ? null :
                (List<String []>)((ArrayList<String []>)data.get("parentLines")).clone();
        String operator = (String)data.get("operator");

        Map<String, Object> params =
                (Map<String, Object>)((HashMap<String, Object>)data).clone();

        if (splitParent.length == 0 && drillLevel == 1) {
            this.getReport().resetSkipTiles();
        }

        String errorTitleText = filter.isEmpty() || drillLevel == 1 ?
                this.getTitle() + ":" :
                this.getTitle() + " with filter: " + filter;

        this.setErrorTitle(errorTitleText);

        AtomicInteger lineCount = new AtomicInteger(0);
        AtomicBoolean isLineMatch = new AtomicBoolean(false);
        AtomicReference<Map<String, Object>> tally =
                new AtomicReference<>(new HashMap<>());

        params.put("splitParent", splitParent);

        for (int filterCount=0; filterCount<this.getFields().length; filterCount++) {

            String finalCmd = cmd + this.getQuerySuffix(filter, filterCount);

            List<String []> lines = this.getQueryLines(finalCmd);

            Tile tile = this.cloneTile();

            if (! this.getNoDrill()) {
                Util.debugOutput(new HashMap<String, Object>() {{
                    put("tile", tile);
                    put("finalCmd", finalCmd);
                    put("lines", lines);
                    put("parentLine", String.join(tile.getSplitChar(), splitParent));
                    put("skipCompare", isCellDrill);
                }});
            }

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
                        params.put("lineCount", lineCount.get());

                        Map<String, Object> result = this.handleTestBufferLine(params);

                        isBreak.set((boolean)result.get("break"));
                        isLineMatch.set((boolean)result.get("isLineMatch"));
                        tally.set((HashMap<String, Object>)result.get("tally"));
                    });

            if (isBreak.get()) {
                // no need to check remaining lines as the matching line was found
                break;
            }
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


        if (! filter.isEmpty() && ! this.getNoDrill()) {
//            this.checkTallies(filter, testResults.get("tally"));
        }

        if (isCellDrill || splitParent.length == 0) {
            return testResults;
        }

        if (lineCount.get() == 0) {
            this.lineErrors(new HashMap<String, Object>() {{
                put("splitLine", null);
                put("splitParent", splitParent);
                put("isOutput", true);
                put("lineCount", 1);
            }});
        } else if (! this.getIsSingleLine() && ! isLineMatch.get()) {

            String lineErrorCaption = this.getLineErrorCaption(splitParent);

            this.logError("\t" + lineErrorCaption + ":\n\t\tNO MATCH FOUND");
        }

        return testResults;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillTile(Map<String, Object> data) {

        String line = (String)data.get("line");
        String [] split = (String [])((String [])data.get("split")).clone();
        String filter = (String)data.get("filter");
        int filterCount = (int)data.get("filterCount");
        int drillLevel = (int)data.get("drillLevel");

        String finalFilter = this.getDrillFilter(new HashMap<String, Object>() {{
            put("split", split);
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

        Report drillReport = this.getReport().cloneReport();

        drillReport.addSkipTile(this.getTrueName());
        drillReport.tests(drillLevel + 1, finalFilter);
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillCell(Map<String, Object> data) {

        String filter = (String)data.get("filter");
        Map<String, Object> params = (Map<String, Object>)((HashMap<String, Object>)data).clone();

        params.put("isCellDrill", true);

        this.getColumns().values().parallelStream()
                .filter(values -> values.get("cellDrill") != null)
                .forEach(values -> {

                    int order = (int)values.get("order");

                    params.put("cellDrill", order);

                    for (String operator : new String [] {null, "not"}) {
                        if (operator == null && this.getIsSingleLine()
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

    private Map<String, String> getDrillTime(String [] split) {

        String beginTime = this.getReportTime().get("beginTime");
        String endTime = this.getReportTime().get("endTime");

        Map<String, String> beginEndTime = new HashMap<String, String>() {{
            put("startTime", beginTime);
            put("stopTime", endTime);
        }};
        // do not use parallelStream() as startTime/stopTime columns most likely are at the beginning of the column list
        this.getColumns().values().stream()
                .filter(info -> info.get("startTime") != null || info.get("stopTime") != null)
                .forEach(info -> {

                    int order = (int)info.get("order");
                    String timeField = info.get("startTime") == null ?
                            "stopTime" : "startTime";

                    String originalTime = split[order];

                    if (originalTime.equals("NA") && this.getTitle().equals("Web Sessions")) {

                        originalTime = Long.toString(System.currentTimeMillis() / 1000L);

                    } else {

                        Object index = info.get("concat");

                        originalTime += index == null ? "" : "." + split[(int)index];
                    }

                    String alteration = info.get(timeField).toString();

                    if (alteration.isEmpty()) {
                        beginEndTime.put(timeField, originalTime);
                    } else {

                        String adjustedTime = this.getAdjustedTime(alteration, originalTime);

                        beginEndTime.put(timeField, adjustedTime);
                    }
                });

        return beginEndTime;
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

        this.getColumns().forEach((column, info) -> {

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

    private boolean checkLine(Map<String, Object> data) {

        String [] splitLine = (String [])((String [])data.get("splitLine")).clone();
        String [] splitParent = (String [])((String [])data.get("splitParent")).clone();
        boolean isTileSingleLine = (boolean)data.get("isTileSingleLine");

        Map<String, Object> params =
                (Map<String, Object>)((HashMap<String, Object>)data).clone();

        if (isTileSingleLine) {
            // there should be only one line on link drill
            if (Arrays.equals(splitLine, splitParent)) {
                return true;
            } else {
                // original (parent) and result (after drill) lines do not match
                params.put("isOutput", true);

                this.lineErrors(params);

                return false;
            }
        } else {
            // there can be many lines on link drill. One of those lines should match
            params.put("isOutput", false);

            return this.lineErrors(params);
        }
    }

    //**************************************************************************

    private String getDrillFilter(Map<String, Object> data) {

        String [] split = (String [])((String [])data.get("split")).clone();
        String filter = (String)data.get("filter");
        int filterCount = (int)data.get("filterCount");
        int cellDrill = data.get("cellDrill") == null ? 0 :
                (int)data.get("cellDrill");
        String operator = (String)data.get("operator");

        AtomicReference<String> rowFilter = new AtomicReference<>("");
        AtomicReference<List<Map<String, Object>>> filterInfo =
                new AtomicReference<>(new ArrayList<>());

        this.getColumns().entrySet().parallelStream()
                .filter(info -> {

                    Map<String, Object> value = (Map<String, Object>)info.getValue();

                    return cellDrill == 0 && value.get("filter") != null
                        || cellDrill == (int)value.get("order") && value.get("cellDrill") != null;
                })
                .forEach(info -> {

                    int count = (int)info.getValue().get("order");

                    Map<String, Object> params = new HashMap<String, Object>() {{
                        put("filterColumn", info.getKey());
                        put("value", split[count]);
                        put("filterCount", filterCount);
                        put("cellDrill", cellDrill);
                        put("split", split);
                    }};

                    String filterField = this.checkIfCustomRowFilter() ?
                            this.getRowFilter(params) :
                            this.getCommon().getCommonRowFilter(params);

                    if (! filterField.isEmpty()) {

                        List<Map<String, Object>> infoValues = filterInfo.get();

                        infoValues.add(new HashMap<String, Object>() {{
                            put("column", info.getKey());
                            put("order", count);
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

    private boolean lineErrors(Map<String, Object> data) {

        String [] splitLine = data.get("splitLine") == null ? null :
                (String [])((String [])data.get("splitLine")).clone();
        String [] splitParent = (String [])((String [])data.get("splitParent")).clone();
        boolean isOutput = (boolean)data.get("isOutput");
        int lineCount = (int)data.get("lineCount");

        String lineErrorCaption = this.getLineErrorCaption(splitParent);

        AtomicBoolean isCaptionPrined = new AtomicBoolean(false);
        AtomicBoolean isError = new AtomicBoolean(false);

        if (lineCount == 1) {
            // check if drilled row Start/Stop Time data do not contradict report's Begin/End Time
            boolean captionPrined = this.timeError(splitParent);

            isCaptionPrined.set(captionPrined);
        }

        if (splitLine == null || splitLine.length == 0) {
            if (isOutput) {
                if (! isCaptionPrined.getAndSet(true)) {
                    this.logError("\t" + lineErrorCaption + ":");
                }

                this.logError("\t\tNO DATA");
            }
            // exit as drilled row has no data
            return true;
        }
        // drilled row has some data so have to compare it with parent's row data
        this.getColumns().forEach((column, info) -> {

            int count = (Integer)info.get("order");

            String parent = splitParent[count];
            String drilled = splitLine[count];

            Object compare = info.get("compare");
            Object filter = info.get("filter");

            if (compare == null && filter == null || drilled.equals(parent)) {
                // break as either no need to compare ot parent and drilled data match
                return;
            }
            // at least one pair of values subject to compareson do not match
            if (! isOutput) {

                isError.set(true);
                // break as there is no need to output errors
                return;
            }

            if (compare != null && compare.toString().equals("number")) {
                parent = Util.getPrettyNumber(parent);
                drilled = Util.getPrettyNumber(drilled);
            }

            if (! isCaptionPrined.getAndSet(true)) {
                this.logError("\t" + lineErrorCaption + ":");
            }

            this.logError("\t\t" + column + ": " + parent + " # " + drilled);
        });

        return ! isError.get();
    }

    //**************************************************************************

    private boolean timeError(String [] splitParent) {

        String lineErrorCaption = this.getLineErrorCaption(splitParent);

        ConcurrentMap<String, String> timeInfo = new ConcurrentHashMap<>();

        this.getColumns().values().stream()
                .filter(dontNeed -> timeInfo.size() < 2)
                .forEach(info -> {

                    int count = (int)info.get("order");

                    for (String field : new String [] {"startTime", "stopTime"}) {
                        if (info.get(field) != null) {
                            timeInfo.put(field, splitParent[count]);
                        }
                    }
                });

        if (timeInfo.size() == 2) {

            String lineStartTime = timeInfo.get("startTime");
            String lineStopTime = timeInfo.get("stopTime");
            String reportStartTime = this.getReportTime().get("beginTime");
            String reportStopTime = this.getReportTime().get("endTime");

            double lineDblStartTime = lineStartTime.isEmpty() ? 0 :
                    Double.valueOf(lineStartTime);
            double lineDblStopTime = lineStopTime.isEmpty() ? 0 :
                    Double.valueOf(lineStopTime);
            double reportDblStartTime = Double.valueOf(reportStartTime);
            double reportDblStopTime = Double.valueOf(reportStopTime);

            if (lineDblStopTime < reportDblStartTime
             || lineDblStartTime > reportDblStopTime
             || lineDblStartTime > lineDblStopTime
             || lineDblStartTime == 0 || lineDblStopTime == 0) {

                String beginTime = "Start Time \"" +
                        this.getReportTime().get("beginTimeString") + "\"";
                String endTime = "Stop Time \"" +
                        this.getReportTime().get("endTimeString") + "\"";
                String startTime = "Start Time \"" +
                        Util.getFromTimestamp(lineStartTime) + "\"";
                String stopTime = "Stop Time \"" +
                        Util.getFromTimestamp(lineStopTime) + "\"";

                this.logError("\t" + lineErrorCaption + ":");

                if (lineDblStopTime < reportDblStartTime) {
                    this.logError("\t\tLine " + stopTime +
                            " is less than report " + beginTime);
                }

                if (lineDblStartTime > reportDblStopTime) {
                    this.logError("\t\tLine " + startTime +
                            " is greater than report " + endTime);
                }

                if (lineDblStartTime > lineDblStopTime) {
                    this.logError("\t\tLine " + startTime +
                            " is greater than line " + stopTime);
                }

                if (lineDblStartTime == 0) {
                    this.logError("\t\tLine Start Time equals to 0");
                }

                if (lineDblStopTime == 0) {
                    this.logError("\t\tLine Stop Time equals to 0");
                }
            }

            return true;
        }

        return false;
    }

    //**************************************************************************

    private String getLineErrorCaption(String [] split) {

        AtomicReference<String> caption = new AtomicReference<>("");
        AtomicReference<String> timeRange = new AtomicReference<>("");

        this.getColumns().forEach((column, info) -> {

            int count = (Integer)info.get("order");

            if (info.get("filter") == null) {
                Arrays.stream(new String [] {"startTime", "stopTime"}).parallel()
                        .filter(item -> info.get(item) != null)
                        .forEach(dontNeed -> {

                            String output = Util.getFromTimestamp(split[count]);

                            timeRange.set(timeRange.get() + ", " + column + ": " + output);
                        });
            } else {

                String prev = caption.get();

                String comma = prev.isEmpty() ? "" : ", ";

                caption.set(prev + comma + column + " \"" + split[count] + "\"");
            }
        });

        return caption.toString() + timeRange.toString();
    }

    //**************************************************************************

    private String getQuerySuffix(String customFilter, int filterCount) {

        String finalFilter;
        String commonFilter = this.getFilters().length > 0 ?
                this.getFilter(filterCount) : "";

        if (customFilter == null || customFilter.isEmpty()) {
            finalFilter = commonFilter;
        } else if (commonFilter.isEmpty()) {
            finalFilter = customFilter;
        } else {
            finalFilter = "(" + customFilter + ") and (" + commonFilter + ")";
        }

        String filter = finalFilter.isEmpty() ? "" : " q '" + finalFilter + "'";

        return " " + this.getPrefix() + " " + this.getField(filterCount) +
                    filter + " " + this.getSuffix() + " w " + this.getWindow();
    }

    //**************************************************************************

    public String getTrueName() {

        String clazz = this.getClass().getName();

        int start = clazz.lastIndexOf('.') + 1;

        return clazz.substring(start);
    }

    //**************************************************************************

    private void logError(String error) {

        ErrorsLog.log(this.getErrorTitle());

        this.setErrorTitle("");

        ErrorsLog.log(error);
    }

    //**************************************************************************

    private boolean checkIsDrillable() {

        if (this.getNoDrill()) {
            return false;
        }

        if (this.checkIfCustomRowFilter()) {
            return true;
        }

        return this.getColumns().values().parallelStream()
                .anyMatch(info -> info.get("filter") != null);
    }

    //**************************************************************************

    private boolean checkIfCustomRowFilter() {

        Method isCustomRowFilter = null;

        try {
            isCustomRowFilter = this.getClass()
                    .getDeclaredMethod("getRowFilter", Map.class);
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
        boolean isCellDrill = data.get("isCellDrill") == null ? false :
                (boolean)data.get("isCellDrill");
        String [] splitParent = (String [])((String [])data.get("splitParent")).clone();
        int filterCount = (int)data.get("filterCount");
        String filter = (String)data.get("filter");
        int drillLevel = (int)data.get("drillLevel");
        int lineCount = (int)data.get("lineCount");
        List<String []> parentLines =
                (List<String []>)((ArrayList<String []>)data.get("parentLines")).clone();

        if (! isCellDrill) {

            String [] tallyOn = splitParent.length > 0 ? splitParent : split;

            tally = this.tally(tallyOn, tally);
        }

        final Map<String, Object> updatedTally =
                (Map<String, Object>)((HashMap<String, Object>)tally).clone();
        final boolean updatedIsLineMatch = isLineMatch;

        if (this.getNoDrill() || isCellDrill || ! this.checkIsDrillable()) {
            // some tiles like charts or maps may not be subject to drilling
            return new HashMap<String, Object>() {{
                put("tally", updatedTally);
                put("isLineMatch", updatedIsLineMatch);
                put("break", false);
            }};
        }

        if (splitParent.length == 0) {

            Map<String, String> drillTime = this.getDrillTime(split);

            String drillTileCmd = this.getReport().getCmd(this, drillTime);
            String drillCellCmd = this.getReport().getCmd(this);
            int paramFilterCount = filterCount;

            Map<String, Object> params = new HashMap<String, Object>() {{
                put("cmd", drillCellCmd);
                put("split", split);
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

            boolean isTileSingleLine = this.getIsSingleLine();

            final boolean finalIsLineMatch = this.checkLine(new HashMap<String, Object>() {{
                put("splitLine", split);
                put("splitParent", splitParent);
                put("isTileSingleLine", isTileSingleLine);
                put("lineCount", lineCount);
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
            results.lines().parallel()
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
        String operator = data.get("operator") == null ? "" : (String)data.get("operator");

        String parentValue = splitParent[cellDrill];

        Map<String, List<String []>> result = this.getArrayListIntersection(data);

        List<String []> parentLines = (List<String []>)result.get("parentLines");

        parentLines.stream().parallel()
                .filter(line -> Util.getBufferLineFilter(line))
                .filter(line -> operator.isEmpty() == line[cellDrill].equals(parentValue)) // either both (empty and equal) TRUE or both FALSE
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
        String operator = data.get("operator") == null ? "" : (String)data.get("operator");

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

    private void checkTallies(String filter, Map<String, Object> masterTally) {

        if (masterTally == null) {
            return;
        }

        Map<String, Map<String, Object>> results = this.getTilesTallies(filter);

        results.keySet().parallelStream()
                .filter(tile -> this.checkIfTallyDiffter(results.get(tile), masterTally))
                .forEach(tile -> {
                    ErrorsLog.log("Tile " + tile + " with filter \"" + filter + "\" has NO DATA");
                });
    }

    //**************************************************************************

    private boolean checkIfTallyDiffter(Map<String, Object> tally, Map<String, Object> masterTally) {

        return masterTally.keySet().parallelStream()
                .filter(key -> tally.get(key) == null && (Double)masterTally.get(key) > 0)
                .findAny()
                .isPresent();
    }

    //**************************************************************************

    private Map<String, Map<String, Object>> getTilesTallies(String filter) {

        Map<String, String> tiles = this.getReport().getTiles();
        String commonByClassName = this.getCommonByClassName();
        String masterTitle = this.getTitle();

        Map<String, Map<String, Object>> results = new HashMap<>();

        Map<String, Object> params = new HashMap<String, Object>() {{
            put("filter", filter);
            put("drillLevel", 1);
        }};

        tiles.keySet().parallelStream()
                .forEach(tile -> {

                    Tile testTile = this.getReport().getTileInstance(tile);

                    if (! testTile.getTitle().equals(masterTitle)
                     && testTile.getCommonByClassName().equals(commonByClassName)) {

                        testTile.setNoDrill(true);

                        Map<String, Map<String, Object>> result = testTile.test(params);

                        results.put(testTile.getTrueName(), result.get("tally"));
                    }
                });

        return results;
    }

    //**************************************************************************

}