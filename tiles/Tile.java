package test_java.tiles;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;

import test_java.ErrorsLog;
import test_java.reports.Report;
import test_java.common.Util;
import test_java.common.Consts;
import test_java.tiles.common.Common;
import test_java.tiles.common.CommonBy;

public abstract class Tile implements Cloneable {

    final protected byte debug = 2;

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
    private String[] fields;
    private String[] filters;
    private LinkedHashMap<String, HashMap<String, Object>> filterColumns;
    private LinkedHashMap<String, HashMap<String, Object>> columns;
    private final List<String> cellDrillFilters = new ArrayList<>();
    private String splitChar = " ";
    private int columnIncrement = 1;
    private String lineTally;
    private boolean removeFirstItem = false;

    //**************************************************************************

    public abstract void setWindow(float window);

    //**************************************************************************

    private Report getReport() {

        return this.report;
    }

    //**************************************************************************

    final public void setReport(final Report report) {

        this.report = report;
    }

    //**************************************************************************

    private Map<String, String> getReportTime() {

        return this.reportTime;
    }

    //**************************************************************************

    final public void setReportTime(final Map<String, String> reportTime) {

        this.reportTime = reportTime;
    }

    //**************************************************************************

    private boolean getNoDrill() {

        return this.noDrill;
    }

    //**************************************************************************

    private void setNoDrill(final boolean noDrill) {

        this.noDrill = noDrill;
    }

    //**************************************************************************

    private String getErrorTitle() {

        return this.errorTitle;
    }

    //**************************************************************************

    private void setErrorTitle(final String errorTitle) {

        this.errorTitle = errorTitle;
    }

    //**************************************************************************

    final protected Common getCommon() {

        return this.common;
    }

    //**************************************************************************

    final protected void setCommon(final Common common) {

        this.common = common;
    }

    //**************************************************************************

    final protected CommonBy getCommonBy() {

        return this.commonBy;
    }

    //**************************************************************************

    final protected void setCommonBy(final CommonBy commonBy) {

        this.commonBy = commonBy;
    }

    //**************************************************************************

    final public String getAppPath() {

        return this.appPath;
    }

    //**************************************************************************

    final protected void setAppPath(final String appPath) {

        this.appPath = appPath;
    }

    //**************************************************************************

    private boolean getIsSingleLine() {

        return this.isSingleLine;
    }

    //**************************************************************************

    final protected void setIsSingleLine(final boolean isSingleLine) {

        this.isSingleLine = isSingleLine;
    }

    //**************************************************************************

    final public String getTitle() {

        return this.title;
    }

    //**************************************************************************

    final protected void setTitle(final String title) {

        this.title = title;
    }

    //**************************************************************************

    private String getTileType() {

        return this.tileType;
    }

    //**************************************************************************

    final protected void setTileType(final String tileType) {

        this.tileType = tileType;
    }

    //**************************************************************************

    final protected String getPrefix() {

        return this.prefix;
    }

    //**************************************************************************

    final protected void setPrefix(final String prefix) {

        this.prefix = prefix;
    }

    //**************************************************************************

    final protected String getSuffix() {

        return this.suffix;
    }

    //**************************************************************************

    final protected void setSuffix(final String suffix) {

        this.suffix = suffix;
    }

    //**************************************************************************

    final protected String getWindow() {

        return this.window;
    }

    //**************************************************************************

    final protected void setWindow(final String window) {

        this.window = window;
    }

    //**************************************************************************

    final protected String[] getFields() {

        return this.fields;
    }

    //**************************************************************************

    final protected String getField(final int index) {

        return this.getFields()[index];
    }

    //**************************************************************************

    final protected void setFields() {

        this.setFields(new String[] {""});
    }

    //**************************************************************************

    final protected void setFields(final String[] fields) {

        this.fields = fields;
    }

    //**************************************************************************

    final protected void setField(final int index, final String field) {

        this.fields[index] = field;
    }

    //**************************************************************************

    final protected String[] getFilters() {

        return this.filters;
    }

    //**************************************************************************

    final protected String getFilter(final int index) {

        return this.getFilters()[index];
    }

    //**************************************************************************

    final protected void setFilters() {

        this.setFilters(new String[] {""});
    }

    //**************************************************************************

    final protected void setFilters(final String[] filters) {

        this.filters = filters;
    }

    //**************************************************************************

    final protected void setFilter(final int index, final String filter) {

        this.filters[index] = filter;
    }

    //**************************************************************************

    final protected LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return this.filterColumns;
    }

    //**************************************************************************

    final protected void setFilterColumns(final LinkedHashMap<String, HashMap<String, Object>> filterColumns) {

        this.filterColumns = filterColumns;
    }

    //**************************************************************************

    final public LinkedHashMap<String, HashMap<String, Object>> getColumns() {

        return this.columns;
    }

    //**************************************************************************

    final protected void setColumns(final LinkedHashMap<String, HashMap<String, Object>> columns) {

        this.columns = columns;
    }

    //**************************************************************************

    private List<String> getCellDrillFilters() {

        return this.cellDrillFilters;
    }

    //**************************************************************************

    private void addCellDrillFilters(final String filter) {

        this.getCellDrillFilters().add(filter);
    }

    //**************************************************************************

    final protected String getSplitChar() {

        return this.splitChar;
    }

    //**************************************************************************

    final protected void setSplitChar(final String splitChar) {

        this.splitChar = splitChar;
    }

    //**************************************************************************

    final protected int getColumnIncrement() {

        return this.columnIncrement;
    }

    //**************************************************************************

    final protected void setColumnIncrement(final int columnIncrement) {

        this.columnIncrement = columnIncrement;
    }

    //**************************************************************************

    private String getLineTally() {

        return this.lineTally;
    }

    //**************************************************************************

    final protected void setLineTally(final String lineTally) {

        this.lineTally = lineTally;
    }

    //**************************************************************************

    private byte getDebug() {

        return this.debug;
    }

    //**************************************************************************

    private boolean getRemoveFirstItem() {

        return this.removeFirstItem;
    }

    //**************************************************************************

    final protected void setRemoveFirstItem(final boolean removeFirstItem) {

        this.removeFirstItem = removeFirstItem;
    }

    //**************************************************************************

    @Override
    final protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    //**************************************************************************

    protected String getRowFilter(final Map<String, Object> data) {

        return "";
    }

    //**************************************************************************

    final protected String getCommonByClassName() {

        return this.getCommonBy() == null ? "" :
                this.getCommonBy().getClass().getName();
    }

    //**************************************************************************

    public BufferedReader getQueryResults(final String finalCmd) {

        final String shellFile = "run_query-" + UUID.randomUUID().toString() + ".sh";

        try (final PrintWriter out = new PrintWriter(shellFile)) {
            out.println(finalCmd);
        } catch (FileNotFoundException e) {
            System.err.println(Consts.getBrightRed() + "File " + shellFile + " was not found");
            System.exit(1);
        }

        try {

            final AtomicReference<Runtime> runtime =
                    new AtomicReference<>(Runtime.getRuntime());

            final AtomicReference<Process> process =
                    new AtomicReference<>(runtime.get().exec("sh " + shellFile));

            final AtomicReference<InputStream> inputStream =
                    new AtomicReference<>(process.get().getInputStream());

            final AtomicReference<InputStreamReader> inputStreamReader =
                    new AtomicReference<>(new InputStreamReader(inputStream.get()));

            return new BufferedReader(inputStreamReader.get());
        } catch (IOException e) {
            System.err.println(Consts.getBrightRed() + "Error running " + shellFile);
            System.exit(1);
        }

        return null;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public Map<String, Map<String, Object>> test(final Map<String, Object> data) {

        final String cmd = data.get("cmd") == null ? this.getReport().getCmd(this) :
                (String)data.get("cmd");
        final String filter = (String)data.get("filter");
        final int drillLevel = (int)data.get("drillLevel");
        final String[] splitParent = data.get("split") == null ? new String[] {} :
                (String[])((String[])data.get("split")).clone();
        final boolean isCellDrill = data.get("isCellDrill") == null ? false :
                (boolean)data.get("isCellDrill");

        final byte gebugParam = this.getDebug();
        final String titleParam = this.getTitle();
        final String splitCharParam = this.getSplitChar();

        final AtomicReference<Map<String, Object>> params =
                new AtomicReference<>((Map)((HashMap)data).clone());
        final AtomicReference<Map<String, Object>> matchedLinesParams =
                new AtomicReference<>((Map)((HashMap)data).clone());

        params.set(Util.updateMap(params.get(), "splitParent", splitParent));
        matchedLinesParams.set(Util.updateMap(matchedLinesParams.get(),
                "splitParent", splitParent));

        final AtomicReference<Map<String, Object>> debugParams =
                new AtomicReference<> (new HashMap<String, Object>() {{
                        put("parentLine", String.join(splitCharParam, splitParent));
                        put("skipCompare", isCellDrill);
                        put("gebug", gebugParam);
                        put("title", titleParam);
                        put("splitChar", splitCharParam);
                    }}
                );

        if (splitParent.length == 0 && drillLevel == 1) {
            this.getReport().resetSkipTiles();
        }

        final String errorTitleText = filter.isEmpty() || drillLevel == 1 ?
                this.getTitle() + ":" :
                this.getTitle() + " with filter: " + filter;

        this.setErrorTitle(errorTitleText);

        AtomicInteger lineCount = new AtomicInteger(0);
        AtomicBoolean isLineMatch = new AtomicBoolean(false);
        AtomicReference<Map<String, Object>> tally =
                new AtomicReference<>(new HashMap<>());

        for (int filterCount=0; filterCount<this.getFields().length; filterCount++) {

            final String finalCmd = cmd + this.getQuerySuffix(filter, filterCount);

            final AtomicReference<ArrayList<String[]>> lines =
                    new AtomicReference<>(new ArrayList(this.getQueryLines(finalCmd)));

            if (! this.getNoDrill()) {

                debugParams.set(Util.updateMap(debugParams.get(), "finalCmd", finalCmd));
                debugParams.set(Util.updateMap(debugParams.get(), "lines", lines.get()));

                Util.debugOutput(debugParams.get());
            }

            if (isCellDrill) {

                matchedLinesParams.set(Util.updateMap(matchedLinesParams.get(),
                        "lines", lines.get()));

                this.checkMatchedLines(matchedLinesParams.get());

                continue;
            }

            AtomicBoolean isBreak = new AtomicBoolean(false);

            params.set(Util.updateMap(params.get(), "filterCount", filterCount));
            params.set(Util.updateMap(params.get(), "parentLines", lines.get()));

            lines.get().parallelStream()
                    .filter(line -> ! isBreak.get() && Util.getBufferLineFilter(line))
                    .forEach(line -> {

                        final boolean isMatch = isLineMatch.get();
                        final int count = lineCount.incrementAndGet();

                        params.set(Util.updateMap(params.get(), "split", line));
                        params.set(Util.updateMap(params.get(), "isLineMatch", isMatch));
                        params.set(Util.updateMap(params.get(), "tally", tally.get()));
                        params.set(Util.updateMap(params.get(), "lineCount", count));

                        final AtomicReference<Map<String, Object>> result =
                                new AtomicReference<>(this.handleTestBufferLine(params.get()));

                        isBreak.set((boolean)result.get().get("break"));
                        isLineMatch.set((boolean)result.get().get("isLineMatch"));
                        tally.set((HashMap)result.get().get("tally"));
                    });

            if (isBreak.get()) {
                // no need to check remaining lines as the matching line was found
                break;
            }
        }

        final AtomicReference<Map<String, Map<String, Object>>> testResults =
                new AtomicReference<>(new HashMap<>());

        if (! isCellDrill) {
            // do not need to tally if drilling on a field
            final AtomicReference<Map<String, Object>> drillTally =
                new AtomicReference<>(tally.get());

            if (this.getLineTally() != null) {

                final double count = (double)lineCount.get();

                drillTally.set(Util.updateMap(drillTally.get(),
                        this.getLineTally(), count));
            }

            testResults.set(Util.updateMap(testResults.get(), "tally", drillTally.get()));
        }


        if (! filter.isEmpty() && ! this.getNoDrill()) {
            this.checkTallies(filter, testResults.get().get("tally"));
        }

        if (isCellDrill || splitParent.length == 0) {
            return testResults.get();
        }

        if (lineCount.get() == 0) {
            this.lineErrors(new HashMap<String, Object>() {{
                put("splitLine", null);
                put("splitParent", splitParent);
                put("isOutput", true);
                put("lineCount", 1);
            }});
        } else if (! this.getIsSingleLine() && ! isLineMatch.get()) {

            final String lineErrorCaption = this.getLineErrorCaption(splitParent);

            this.logError("\t" + lineErrorCaption + ":\n\t\tNO MATCH FOUND");
        }

        return testResults.get();
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillTile(final Map<String, Object> data) {

        final String line = (String)data.get("line");
        final int drillLevel = (int)data.get("drillLevel");

        final AtomicReference<Map<String, Object>> params =
                new AtomicReference<>((Map)((HashMap)data).clone());

        final String finalFilter = this.getDrillFilter(params.get());

        params.set(Util.removeFromMap(params.get(), "splitParent"));
        params.set(Util.removeFromMap(params.get(), "filterCount"));
        params.set(Util.updateMap(params.get(), "filter", finalFilter));
        params.set(Util.updateMap(params.get(), "parentLine", line));

        this.test(params.get());

        final Report testReport = this.getReport().cloneReport();

        testReport.addSkipTile(this.getTrueName());
        testReport.tests(drillLevel + 1, finalFilter);
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillCell(final Map<String, Object> data) {

        final String filter = (String)data.get("filter");
        final AtomicReference<Map<String, Object>> params =
                new AtomicReference<>((Map)((HashMap)data).clone());

        params.set(Util.updateMap(params.get(), "isCellDrill", true));
        params.set(Util.updateMap(params.get(), "filter", filter));

        final boolean singleLine = this.getIsSingleLine();

        this.getColumns().values().parallelStream()
                .filter(values -> values.get("cellDrill") != null)
                .forEach(values -> {

                    final int order  = (int)values.get("order");

                    params.set(Util.updateMap(params.get(), "cellDrill", order));
                    params.set(Util.updateMap(params.get(), "singleLine", singleLine));

                    this.drillCellExecute(params.get());
                });
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillCellExecute(final Map<String, Object> data) {

        final String oldFilter = (String)data.get("filter");
        final AtomicReference<Map<String, Object>> params =
                new AtomicReference<>((Map)((HashMap)data).clone());

        Arrays.stream(new String[] {null, "not"}).parallel()
                .filter(operator -> {
                    // may need to skip as row drill will perform the same action as call drill
                    return operator != null || ! (boolean)params.get().get("singleLine");
                })
                .forEach(operator -> {
                    // have to reset "filter" before passing it to getDrillFilter() method
                    params.set(Util.updateMap(params.get(), "filter", oldFilter));
                    params.set(Util.updateMap(params.get(), "operator", operator));

                    final String newFilter = this.getDrillFilter(params.get());

                    params.set(Util.updateMap(params.get(), "filter", newFilter));

                    if (! this.getCellDrillFilters().contains(newFilter)) {

                        this.addCellDrillFilters(newFilter);

                        this.test(params.get());
                    }
                });
    }

    //**************************************************************************

    private Map<String, String> getDrillTime(final String[] split) {

        final String beginTime = this.getReportTime().get("beginTime");
        final String endTime = this.getReportTime().get("endTime");

        final AtomicReference<Map<String, String>> beginEndTime =
                new AtomicReference<> (new HashMap<String, String>() {{
                        put("startTime", beginTime);
                        put("stopTime", endTime);
                    }}
                );
        // do not use parallelStream() as startTime/stopTime columns most likely are at the beginning of the column list
        this.getColumns().values().stream()
                .filter(info -> info.get("startTime") != null || info.get("stopTime") != null)
                .forEach(info -> {

                    final int order = (int)info.get("order");
                    final String timeField = info.get("startTime") == null ?
                            "stopTime" : "startTime";

                    String originalTime = split[order];

                    if (originalTime.equals("NA") && this.getTitle().equals("Web Sessions")) {
                        originalTime = Long.toString(System.currentTimeMillis() / 1000L);
                    } else {

                        final Object index = info.get("concat");

                        originalTime += index == null ? "" : "." + split[(int)index];
                    }

                    final String alteration = info.get(timeField).toString();

                    final String adjustedTime = alteration.isEmpty() ? originalTime :
                            this.getAdjustedTime(alteration, originalTime);

                    beginEndTime.set(Util.updateMap(beginEndTime.get(),
                            timeField, adjustedTime));
                });

        return beginEndTime.get();
    }

    //**************************************************************************

    private String getAdjustedTime(final String alteration, final String originalTime) {

        final String[] timeAlter = alteration.split("\\s+");

        final String sign = timeAlter[0];
        int value = Integer.valueOf(timeAlter[1]);
        final String measure = timeAlter[2];
        // split time string by "." to seconds and microseconds
        final String[] splitTime = originalTime.split("\\.");

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

        final Float adjustedMicroSeconds = Float.valueOf(microSeconds) / 1000000;

        final String timeSeconds = String.valueOf(seconds);
        final String timeMicroSeconds = String.format("%.6f", adjustedMicroSeconds);
        // have to remove "0" before "." when concatenating seconds with microseconds
        final String adjustedTime = timeSeconds + timeMicroSeconds.substring(1);

        return adjustedTime;
    }

    //**************************************************************************

    private Map<String, Object> tally(
            final String[] split, final Map<String, Object> tally
    ) {

        this.getColumns().forEach((column, info) -> {

            final int index = (int)info.get("order");
            final Object isTally = info.get("tally");

            if (isTally != null && isTally.toString().equals("true")) {

                Object tallied = tally.get(column);

                tallied = tallied == null ? 0D : tallied;

                tally.put(column, (double)tallied + Double.valueOf(split[index]));
            }
        });

        return tally;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private boolean checkLine(final Map<String, Object> data) {

        final String[] splitLine = (String[])((String[])data.get("splitLine")).clone();
        final String[] splitParent = (String[])((String[])data.get("splitParent")).clone();
        final boolean isTileSingleLine = (boolean)data.get("isTileSingleLine");

        final AtomicReference<Map<String, Object>> params =
                new AtomicReference<>((Map)((HashMap)data).clone());

        if (isTileSingleLine) {
            // there should be only one line on link drill
            if (Arrays.equals(splitLine, splitParent)) {
                return true;
            } else {
                // original (parent) and result (after drill) lines do not match
                params.set(Util.updateMap(params.get(), "isOutput", true));

                this.lineErrors(params.get());

                return false;
            }
        } else {
            // there can be many lines on link drill. One of those lines should match
            params.set(Util.updateMap(params.get(), "isOutput", false));

            return this.lineErrors(params.get());
        }
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private String getDrillFilter(final Map<String, Object> data) {

        final String[] split = (String[])((String[])data.get("split")).clone();
        final String filter = (String)data.get("filter");
        final int filterCount = (int)data.get("filterCount");
        final int cellDrill = data.get("cellDrill") == null ? 0 :
                (int)data.get("cellDrill");
        final String operator = (String)data.get("operator");

        AtomicReference<String> rowFilter = new AtomicReference<>("");
        AtomicReference<List<Map<String, Object>>> filterInfo =
                new AtomicReference<>(new ArrayList<>());

        this.getColumns().entrySet().parallelStream()
                .filter(info -> {

                    final AtomicReference<Map<String, Object>> value =
                            new AtomicReference<>((Map)info.getValue());

                    return cellDrill == 0 && value.get().get("filter") != null
                        || cellDrill == (int)value.get().get("order") && value.get().get("cellDrill") != null;
                })
                .forEach(info -> {

                    final int index = (int)info.getValue().get("order");

                    final AtomicReference<Map<String, Object>> params =
                            new AtomicReference<>(
                                    new HashMap<String, Object>() {{
                                        put("filterColumn", info.getKey());
                                        put("value", split[index]);
                                        put("filterCount", filterCount);
                                        put("cellDrill", cellDrill);
                                        put("split", split);
                                    }}
                            );

                    final String filterField = this.checkIfCustomRowFilter() ?
                            this.getRowFilter(params.get()) :
                            this.getCommon().getCommonRowFilter(params.get());

                    if (! filterField.isEmpty()) {

                        List<Map<String, Object>> infoValues = filterInfo.get();

                        infoValues.add(new HashMap<String, Object>() {{
                            put("column", info.getKey());
                            put("order", index);
                            put("value", split[index]);
                        }});

                        filterInfo.set(infoValues);

                        String value = rowFilter.get();

                        value += value.isEmpty() ? "" : " and ";

                        rowFilter.set(value + filterField);
                    }
                });

        final String drillFilter = operator == null ? rowFilter.toString() :
                operator + " (" + rowFilter.toString() + ")";

        return filter.isEmpty() ? drillFilter : "(" + filter + ") and (" + drillFilter + ")";
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private boolean lineErrors(final Map<String, Object> data) {

        final String[] splitLine = data.get("splitLine") == null ? null :
                (String[])((String[])data.get("splitLine")).clone();
        final String[] splitParent = (String[])((String[])data.get("splitParent")).clone();
        final boolean isOutput = (boolean)data.get("isOutput");
        final int lineCount = (int)data.get("lineCount");

        final String lineErrorCaption = this.getLineErrorCaption(splitParent);

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

            final int index = (Integer)info.get("order");

            String parent = splitParent[index];
            String drilled = splitLine[index];

            final Object compare = info.get("compare");
            final Object filter = info.get("filter");

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

    private boolean timeError(final String[] splitParent) {

        final AtomicReference<Map<String, String>> timeInfo =
                new AtomicReference<>(new HashMap<>());

        this.getColumns().values().stream()
                .filter(dontNeed -> timeInfo.get().size() < 2)
                .forEach(info -> {

                    final int index = (int)info.get("order");

                    final String parent = splitParent[index];

                    Arrays.stream(new String[] {"startTime", "stopTime"}).parallel()
                            .filter(field -> info.get(field) != null)
                            .forEach(field -> {
                                timeInfo.set(Util.updateMap(timeInfo.get(), field, parent));
                            });
                });

        if (timeInfo.get().size() != 2) {
            return false;
        }

        final String lineStartTime = timeInfo.get().get("startTime");
        final String lineStopTime = timeInfo.get().get("stopTime");
        final String reportStartTime = this.getReportTime().get("beginTime");
        final String reportStopTime = this.getReportTime().get("endTime");

        final double lineDblStartTime = lineStartTime.isEmpty() ? 0 :
                Double.valueOf(lineStartTime);
        final double lineDblStopTime = lineStopTime.isEmpty() ? 0 :
                Double.valueOf(lineStopTime);
        final double reportDblStartTime = Double.valueOf(reportStartTime);
        final double reportDblStopTime = Double.valueOf(reportStopTime);

        boolean isCaptionPrinted = false;

        if (lineDblStopTime < reportDblStartTime
         || lineDblStartTime > reportDblStopTime
         || lineDblStartTime > lineDblStopTime
         || lineDblStartTime == 0 || lineDblStopTime == 0) {

            final String beginTime = "Start Time \"" +
                    this.getReportTime().get("beginTimeString") + "\"";
            final String endTime = "Stop Time \"" +
                    this.getReportTime().get("endTimeString") + "\"";
            final String startTime = "Start Time \"" +
                    Util.getFromTimestamp(lineStartTime) + "\"";
            final String stopTime = "Stop Time \"" +
                    Util.getFromTimestamp(lineStopTime) + "\"";

            isCaptionPrinted = true;

            this.logError("\t" + this.getLineErrorCaption(splitParent) + ":");

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

        return isCaptionPrinted;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private String getLineErrorCaption(final String[] split) {

        AtomicReference<String> caption = new AtomicReference<>("");
        AtomicReference<String> timeRange = new AtomicReference<>("");

        this.getColumns().forEach((column, info) -> {

            final int index = (Integer)info.get("order");

            if (info.get("filter") == null) {
                Arrays.stream(new String[] {"startTime", "stopTime"}).parallel()
                        .filter(item -> info.get(item) != null)
                        .forEach(dontNeed -> {

                            String output = Util.getFromTimestamp(split[index]);

                            timeRange.set(timeRange.get() + ", " + column + ": " + output);
                        });
            } else {

                final String prev = caption.get();

                final String comma = prev.isEmpty() ? "" : ", ";

                caption.set(prev + comma + column + " \"" + split[index] + "\"");
            }
        });

        return caption.toString() + timeRange.toString();
    }

    //**************************************************************************

    private String getQuerySuffix(final String customFilter, final int filterCount) {

        String finalFilter;
        final String commonFilter = this.getFilters().length > 0 ?
                this.getFilter(filterCount) : "";

        if (customFilter == null || customFilter.isEmpty()) {
            finalFilter = commonFilter;
        } else if (commonFilter.isEmpty()) {
            finalFilter = customFilter;
        } else {
            finalFilter = "(" + customFilter + ") and (" + commonFilter + ")";
        }

        final String filter = finalFilter.isEmpty() ? "" : " q '" + finalFilter + "'";

        return " " + this.getPrefix() + " " + this.getField(filterCount) +
                    filter + " " + this.getSuffix() + " w " + this.getWindow();
    }

    //**************************************************************************

    public String getTrueName() {

        final String clazz = this.getClass().getName();

        final int start = clazz.lastIndexOf('.') + 1;

        return clazz.substring(start);
    }

    //**************************************************************************

    private void logError(final String error) {

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
    private Map<String, Object> handleTestBufferLine(final Map<String, Object> data) {

        final String[] split = (String[])((String[])data.get("split")).clone();
        final boolean isLineMatch = (boolean)data.get("isLineMatch");
        final boolean isCellDrill = data.get("isCellDrill") == null ? false :
                (boolean)data.get("isCellDrill");
        final String[] splitParent = (String[])((String[])data.get("splitParent")).clone();
        final int filterCount = (int)data.get("filterCount");
        final String filter = (String)data.get("filter");
        final int drillLevel = (int)data.get("drillLevel");
        final int lineCount = (int)data.get("lineCount");
        final List<String[]> parentLines = (List)((ArrayList)data.get("parentLines")).clone();

        final String[] tallyOn = splitParent.length > 0 ? splitParent : split;

        final AtomicReference<Map<String, Object>> tallyParam = new AtomicReference<>(
                isCellDrill ? (Map)data.get("tally") : this.tally(tallyOn, (Map)data.get("tally"))
        );

        if (this.getNoDrill() || isCellDrill || ! this.checkIsDrillable()) {
            // some tiles like charts or maps may not be subject to drilling
            return new HashMap<String, Object>() {{
                put("tally", tallyParam.get());
                put("isLineMatch", isLineMatch);
                put("break", false);
            }};
        }

        if (splitParent.length == 0) {

            final String drillTileCmd = this.getReport().getCmd(this,
                    this.getDrillTime(split));
            final String drillCellCmd = this.getReport().getCmd(this);

            final AtomicReference<Map<String, Object>> params =
                    new AtomicReference<>(
                            new HashMap<String, Object>() {{
                                put("cmd", drillCellCmd);
                                put("split", split);
                                put("filter", filter);
                                put("filterCount", filterCount);
                                put("drillLevel", drillLevel);
                                put("parentLines", parentLines);
                            }}
                    );

            this.drillCell(params.get());
            // overwriting "cmd" key with a new value for tile drill

            params.set(Util.updateMap(params.get(), "cmd", drillTileCmd));

            this.drillTile(params.get());
        } else {

            final boolean isTileSingleLine = this.getIsSingleLine();

            final boolean finalIsLineMatch = this.checkLine(new HashMap<String, Object>() {{
                put("splitLine", split);
                put("splitParent", splitParent);
                put("isTileSingleLine", isTileSingleLine);
                put("lineCount", lineCount);
            }}) || isLineMatch;

            if (! isTileSingleLine && finalIsLineMatch) {
                return new HashMap<String, Object>() {{
                   put("tally", tallyParam.get());
                   put("isLineMatch", finalIsLineMatch);
                   put("break", true);
               }};
            }
        }

        return new HashMap<String, Object>() {{
            put("tally", tallyParam.get());
            put("isLineMatch", isLineMatch);
            put("break", false);
        }};
    }

    //**************************************************************************

    private List<String[]> getQueryLines(final String finalCmd) {

        final String splitBy = this.getSplitChar();
        final int shift = this.getRemoveFirstItem() ? 1 : 0;
        final CopyOnWriteArrayList<String[]> result = new CopyOnWriteArrayList();

        this.getQueryResults(finalCmd).lines().parallel()
                .forEach(line -> {
                    result.add(Util.split(line.trim(), splitBy, shift));
                });

        return new ArrayList(result);
    }

    //**************************************************************************

    private String getColumnTitle(final int order) {

        return this.getColumns().entrySet().stream()
                .filter(item -> (int)item.getValue().get("order") == order)
                .findFirst()
                .get()
                .getKey();
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void checkMatchedLines(final Map<String, Object> data) {

        final String[] splitParent = (String[])((String[])data.get("splitParent")).clone();
        final int cellDrill = (int)data.get("cellDrill");
        final String filter = (String)data.get("filter");
        final String operator = data.get("operator") == null ? "" :
                (String)data.get("operator");

        final String columnTitle = this.getColumnTitle(cellDrill);
        final String parentValue = splitParent[cellDrill];

        final AtomicReference<Map<String, Object>> params = new AtomicReference<>(data);
        final AtomicReference<Object> compareLeftValue =
                new AtomicReference<>(this.getColumns().get(columnTitle).get("compareLeft"));

        boolean compareLeft = compareLeftValue.get() != null && (boolean)compareLeftValue.get();

        params.set(Util.updateMap(params.get(), "parentValue", parentValue));
        params.set(Util.updateMap(params.get(), "columnTitle", columnTitle));
        params.set(Util.updateMap(params.get(), "compareLeft", compareLeft));

        this.getArrayListIntersection(params.get()).parallelStream()
                .filter(line -> Util.getBufferLineFilter(line))
                .filter(line -> {

                    final boolean isEqual = this.isEqual(parentValue,
                            line[cellDrill], columnTitle);

                    return operator.isEmpty() == isEqual; // either both (empty and equal) TRUE or both FALSE
                })
                .forEach(line -> {
                    this.logDrilledColumnError(new HashMap<String, Object>() {{
                        put("message", "is missing");
                        put("filter", filter);
                        put("columnOrder", cellDrill);
                        put("line", line);
                        put("compareLeft", compareLeft);
                        put("parentValue", parentValue);
                        put("columnTitle", columnTitle);
                    }});
                });
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private List<String[]> getArrayListIntersection(final Map<String, Object> data) {
        // need to convert to thread safe CopyOnWriteArrayList in order to use removeIf()
        final CopyOnWriteArrayList<String []> parentLines =
                new CopyOnWriteArrayList((ArrayList)data.get("parentLines"));
        final List<String[]> filteredLines = (List)((ArrayList)data.get("lines")).clone();
        final String parentValue = (String)data.get("parentValue");
        final int cellDrill = (int)data.get("cellDrill");
        final String filter = (String)data.get("filter");
        final String operator = data.get("operator") == null ? "" :
                (String)data.get("operator");
        final String columnTitle = (String)data.get("columnTitle");

        filteredLines.parallelStream()
                .filter(line -> Util.getBufferLineFilter(line))
                .forEach(line -> {

                    final boolean isEqual = this.isEqual(parentValue,
                            line[cellDrill], columnTitle);

                    if (operator.isEmpty() != isEqual) { // either not empty and equal or empty and not equal
                        this.logDrilledColumnError(new HashMap<String, Object>() {{
                            put("message", "must not have");
                            put("filter", filter);
                            put("columnOrder", cellDrill);
                            put("line", line);
                            put("columnTitle", columnTitle);
                        }});
                    }

                    parentLines.removeIf(parent -> {
                        return Arrays.equals(line, parent) || ! Util.getBufferLineFilter(parent);
                    });
                });

        return parentLines;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void logDrilledColumnError(final Map<String, Object> data) {

        final String message = (String)data.get("message");
        final String[] line = (String[])((String[])data.get("line")).clone();
        final int columnOrder = (int)data.get("columnOrder");
        final String filter = (String)data.get("filter");
        final String columnTitle = (String)data.get("columnTitle");

        this.logError("\t" + "Query with applied filter '" + filter +
                "' " + message + " a line with '" + columnTitle + "' = " +
                "\"" + line[columnOrder] + "\":");

        this.logError("\t\t" + String.join(this.getSplitChar(), line));
    }

    //**************************************************************************

    private boolean isEqual(final String parent, final String child, String columnTitle) {

        final AtomicReference<Map<String, Object>> info =
                new AtomicReference<>(this.getColumns().get(columnTitle));

        boolean equalListEqual = false;
        final boolean compareLeft = info.get().get("compareLeft") != null &&
                (boolean)info.get().get("compareLeft");

        if (info.get().get("equalList") != null) {
            // check if equalList contains parent
            final boolean isParentInList =
                    Arrays.stream((String[])info.get().get("equalList")).parallel()
                            .anyMatch(value -> value.equals(parent));
            // check if equalList contains child
            final boolean isChildInList =
                    Arrays.stream((String[])info.get().get("equalList")).parallel()
                            .anyMatch(value -> value.equals(child));

            equalListEqual = isParentInList && isChildInList;
        }

        final boolean compareLeftEqual = compareLeft ? child.startsWith(parent) :
                child.equals(parent);

        return compareLeftEqual || equalListEqual;
    }

    //**************************************************************************

    private void checkTallies(final String filter, final Map<String, Object> masterTally) {

        if (masterTally == null) {
            return;
        }

        final AtomicReference<Map<String, Map<String, Object>>> results =
                new AtomicReference<>(this.getTilesTallies(filter));
        final String error = " with filter \"" + filter + "\" has NO DATA";

        if (results.get() == null) {
            return;
        }

        results.get().keySet().parallelStream()
                .filter(tile -> this.checkIfTallyDiffer(results.get().get(tile), masterTally))
                .forEach(tile -> ErrorsLog.log("Tile " + tile + error));
    }

    //**************************************************************************

    private boolean checkIfTallyDiffer(
            final Map<String, Object> tally,
            final Map<String, Object> masterTally
    ) {

        return masterTally.keySet().parallelStream()
                .anyMatch(key -> tally.get(key) == null && (Double)masterTally.get(key) > 0);
    }

    //**************************************************************************

    private Map<String, Map<String, Object>> getTilesTallies(final String filter) {

        final String commonByClassName = this.getCommonByClassName();
        final String masterTitle = this.getTitle();

        final AtomicReference<Map<String, Map<String, Object>>> results =
                new AtomicReference<>(new HashMap<>());

        final AtomicReference<Map<String, Object>> params =
                new AtomicReference<>(
                        new HashMap<String, Object>() {{
            put("filter", filter);
            put("drillLevel", 1);
                        }}
                );

        this.getReport().getTiles().keySet().parallelStream()
                .forEach(tile -> {

                    final Tile testTile = this.getReport().getTileInstance(tile);

                    if (testTile.getCommonByClassName().equals(commonByClassName)
                     && ! testTile.getTitle().equals(masterTitle)) {

                        testTile.setNoDrill(true);

                        final AtomicReference<Map<String, Map<String, Object>>> result =
                                new AtomicReference<>(testTile.test(params.get()));

                        final String trueName = testTile.getTrueName();

                        results.set(Util.updateMap(results.get(), trueName,
                                result.get().get("tally")));
                    }
                });

        return results.get();
    }

    //**************************************************************************

}