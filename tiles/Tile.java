package test_java.tiles;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.atomic.*;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;;
import java.util.concurrent.CopyOnWriteArrayList;

import test_java.ErrorsLog;
import test_java.reports.Report;
import test_java.common.Util;
import test_java.common.Consts;
import test_java.tiles.common.Common;
import test_java.tiles.common.CommonBy;

public abstract class Tile implements Cloneable {

    final protected byte debug = 2;

    private final AtomicReference<Report> report = new AtomicReference<>();
    private final AtomicReference<Map<String, String>> reportTime = new AtomicReference<>();
    private final AtomicBoolean noDrill = new AtomicBoolean(false);
    private final AtomicReference<String> errorTitle = new AtomicReference<>("");
    private final AtomicReference<Common> common = new AtomicReference<>();
    private final AtomicReference<CommonBy> commonBy = new AtomicReference<>();
    private final AtomicReference<String> appPath = new AtomicReference<>();
    private final AtomicBoolean isSingleLine = new AtomicBoolean(false);
    private final AtomicReference<String> title = new AtomicReference<>();
    private final AtomicReference<String> tileType = new AtomicReference<>();
    private final AtomicReference<String> prefix = new AtomicReference<>();
    private final AtomicReference<String> suffix = new AtomicReference<>("");
    private final AtomicReference<String> window = new AtomicReference<>("0.0");
    private final AtomicReference<String[]> fields = new AtomicReference<>(new String[] {});
    private final AtomicReference<String[]> filters = new AtomicReference<>(new String[] {});;
    private final AtomicReference<LinkedHashMap<String, ConcurrentHashMap<String, Object>>> filterColumns = new AtomicReference<>();
    private final AtomicReference<LinkedHashMap<String, ConcurrentHashMap<String, Object>>> columns = new AtomicReference<>();
    private final AtomicReference<List<String>> cellDrillFilters = new AtomicReference<>(new ArrayList<>());
    private final AtomicReference<String> splitChar = new AtomicReference<>(" ");
    private final AtomicInteger columnIncrement = new AtomicInteger(1);
    private final AtomicReference<String> lineTally = new AtomicReference<>();
    private final AtomicBoolean removeFirstItem = new AtomicBoolean(false);

    //**************************************************************************

    public abstract void setWindow(float window);

    //**************************************************************************

    private Report getReport() {

        return this.report.get();
    }

    //**************************************************************************

    final public void setReport(final Report report) {

        this.report.set(report);
    }

    //**************************************************************************

    private Map<String, String> getReportTime() {

        return this.reportTime.get();
    }

    //**************************************************************************

    final public void setReportTime(final Map<String, String> reportTime) {

        this.reportTime.set(reportTime);
    }

    //**************************************************************************

    private boolean getNoDrill() {

        return this.noDrill.get();
    }

    //**************************************************************************

    private void setNoDrill(final boolean noDrill) {

        this.noDrill.set(noDrill);
    }

    //**************************************************************************

    private String getErrorTitle() {

        return this.errorTitle.get();
    }

    //**************************************************************************

    private void setErrorTitle(final String errorTitle) {

        this.errorTitle.set(errorTitle);
    }

    //**************************************************************************

    final protected Common getCommon() {

        return this.common.get();
    }

    //**************************************************************************

    final protected void setCommon(final Common common) {

        this.common.set(common);
    }

    //**************************************************************************

    final protected CommonBy getCommonBy() {

        return this.commonBy.get();
    }

    //**************************************************************************

    final protected void setCommonBy(final CommonBy commonBy) {

        this.commonBy.set(commonBy);
    }

    //**************************************************************************

    final public String getAppPath() {

        return this.appPath.get();
    }

    //**************************************************************************

    final protected void setAppPath(final String appPath) {

        this.appPath.set(appPath);
    }

    //**************************************************************************

    private boolean getIsSingleLine() {

        return this.isSingleLine.get();
    }

    //**************************************************************************

    final protected void setIsSingleLine(final boolean isSingleLine) {

        this.isSingleLine.set(isSingleLine);
    }

    //**************************************************************************

    final public String getTitle() {

        return this.title.get();
    }

    //**************************************************************************

    final protected void setTitle(final String title) {

        this.title.set(title);
    }

    //**************************************************************************

    private String getTileType() {

        return this.tileType.get();
    }

    //**************************************************************************

    final protected void setTileType(final String tileType) {

        this.tileType.set(tileType);
    }

    //**************************************************************************

    final protected String getPrefix() {

        return this.prefix.get();
    }

    //**************************************************************************

    final protected void setPrefix(final String prefix) {

        this.prefix.set(prefix);
    }

    //**************************************************************************

    final protected String getSuffix() {

        return this.suffix.get();
    }

    //**************************************************************************

    final protected void setSuffix(final String suffix) {

        this.suffix.set(suffix);
    }

    //**************************************************************************

    final protected String getWindow() {

        return this.window.get();
    }

    //**************************************************************************

    final protected void setWindow(final String window) {

        this.window.set(window);
    }

    //**************************************************************************

    final protected String[] getFields() {

        return this.fields.get();
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

        this.fields.set(fields);
    }

    //**************************************************************************

    final protected void setField(final int index, final String field) {

        final AtomicReference<String[]> array =
                new AtomicReference<>(this.getFields());

        array.get()[index] = field;

        this.fields.set(array.get());
    }

    //**************************************************************************

    final protected String[] getFilters() {

        return this.filters.get();
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

        this.filters.set(filters);
    }

    //**************************************************************************

    final protected void setFilter(final int index, final String filter) {

        final AtomicReference<String[]> array = new AtomicReference<>(this.getFilters());

        array.get()[index] = filter;

        this.filters.set(array.get());
    }

    //**************************************************************************

    final protected LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return this.filterColumns.get();
    }

    //**************************************************************************

    final protected void setFilterColumns(final LinkedHashMap<String, ConcurrentHashMap<String, Object>> filterColumns) {

        this.filterColumns.set(filterColumns);
    }

    //**************************************************************************

    final public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getColumns() {

        return this.columns.get();
    }

    //**************************************************************************

    final protected void setColumns(final LinkedHashMap<String, ConcurrentHashMap<String, Object>> columns) {

        this.columns.set(columns);
    }

    //**************************************************************************

    private List<String> getCellDrillFilters() {

        return this.cellDrillFilters.get();
    }

    //**************************************************************************

    private void addCellDrillFilters(final String filter) {

        this.cellDrillFilters.set(Util.addToList(this.getCellDrillFilters(), filter));
    }

    //**************************************************************************

    final protected String getSplitChar() {

        return this.splitChar.get();
    }

    //**************************************************************************

    final protected void setSplitChar(final String splitChar) {

        this.splitChar.set(splitChar);
    }

    //**************************************************************************

    final protected int getColumnIncrement() {

        return this.columnIncrement.get();
    }

    //**************************************************************************

    final protected void setColumnIncrement(final int columnIncrement) {

        this.columnIncrement.set(columnIncrement);
    }

    //**************************************************************************

    private String getLineTally() {

        return this.lineTally.get();
    }

    //**************************************************************************

    final protected void setLineTally(final String lineTally) {

        this.lineTally.set(lineTally);
    }

    //**************************************************************************

    private byte getDebug() {

        return this.debug;
    }

    //**************************************************************************

    private boolean getRemoveFirstItem() {

        return this.removeFirstItem.get();
    }

    //**************************************************************************

    final protected void setRemoveFirstItem(final boolean removeFirstItem) {

        this.removeFirstItem.set(removeFirstItem);
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

        final ConcurrentHashMap<String, Object> params = new ConcurrentHashMap(data);
        final ConcurrentHashMap<String, Object> matchedLinesParams = new ConcurrentHashMap(data);

        params.put("splitParent", splitParent);
        matchedLinesParams.put("splitParent", splitParent);

        final ConcurrentHashMap<String, Object> debugParams = new ConcurrentHashMap<String, Object>() {{
            put("parentLine", String.join(splitCharParam, splitParent));
            put("skipCompare", isCellDrill);
            put("gebug", gebugParam);
            put("title", titleParam);
            put("splitChar", splitCharParam);
        }};

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
                new AtomicReference<>(new ConcurrentHashMap<>());

        for (int filterCount=0; filterCount<this.getFields().length; filterCount++) {

            final String finalCmd = cmd + this.getQuerySuffix(filter, filterCount);

            final AtomicReference<List<String[]>> lines =
                    new AtomicReference(this.getQueryLines(finalCmd));

            if (! this.getNoDrill()) {

                debugParams.put("finalCmd", finalCmd);
                debugParams.put("lines", lines.get());

                Util.debugOutput(debugParams);
            }

            if (isCellDrill) {

                matchedLinesParams.put("lines", lines.get());

                this.checkMatchedLines(matchedLinesParams);

                continue;
            }

            AtomicBoolean isBreak = new AtomicBoolean(false);

            final int filterCountParam = filterCount;

            lines.get().parallelStream()
                    .filter(line -> ! isBreak.get() && Util.getBufferLineFilter(line))
                    .forEach(line -> {

                        final Map<String, Object> result =
                                this.handleTestBufferLine(new HashMap<String, Object>() {{
                                    put("split", line);
                                    put("isLineMatch", isLineMatch.get());
                                    put("tally", tally.get());
                                    put("isCellDrill", isCellDrill);
                                    put("splitParent", splitParent);
                                    put("filterCount", filterCountParam);
                                    put("filter", filter);
                                    put("drillLevel", drillLevel);
                                    put("lineCount", lineCount.incrementAndGet());
                                    put("parentLines", lines.get());
                                }});

                        isBreak.set((boolean)result.get("break"));
                        isLineMatch.set((boolean)result.get("isLineMatch"));
                        tally.set((ConcurrentHashMap)result.get("tally"));
                    });

            if (isBreak.get()) {
                // no need to check remaining lines as the matching line was found
                break;
            }
        }

        final Map<String, Map<String, Object>> testResults =
                new HashMap<>();

        if (! isCellDrill) {
            // do not need to tally if drilling on a field
            final ConcurrentHashMap<String, Object> drillTally =
                    (ConcurrentHashMap)tally.get();

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

            final String lineErrorCaption = this.getLineErrorCaption(splitParent);

            this.logError("\t" + lineErrorCaption + ":\n\t\tNO MATCH FOUND");
        }

        return testResults;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillTile(final Map<String, Object> data) {

        final String line = Arrays.toString((String[])data.get("line"));
        final int drillLevel = (int)data.get("drillLevel");

        final ConcurrentHashMap<String, Object> params = new ConcurrentHashMap<>(data);

        final String finalFilter = this.getDrillFilter(params);

        params.remove("splitParent");
        params.remove("filterCount");
        params.put("filter", finalFilter);
        params.put("parentLine", line);

        this.test(params);

        final Report testReport = this.getReport().cloneReport();

        testReport.addSkipTile(this.getTrueName());
        testReport.tests(drillLevel + 1, finalFilter);
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillCell(final Map<String, Object> data) {

        final AtomicReference<Map<String, Object>> params =
                new AtomicReference<>((Map)((HashMap)data).clone());

        params.set(Util.updateMap(params.get(), "singleLine", this.getIsSingleLine()));
        params.set(Util.updateMap(params.get(), "isCellDrill", true));

        this.getColumns().values().parallelStream()
                .filter(values -> values.get("cellDrill") != null)
                .forEach(values -> {

                    params.set(Util.updateMap(params.get(), "cellDrill", (int)values.get("order")));

                    this.drillCellExecute(params.get());
                });
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void drillCellExecute(final Map<String, Object> data) {

        Stream.of("", "not").parallel()
                .filter(operator -> {
                    // may need to skip as row drill will perform the same action as call drill
                    return ! operator.isEmpty() || ! (boolean)data.get("singleLine");
                })
                .forEach(operator -> {

                    final AtomicReference<Map<String, Object>> params =
                            new AtomicReference<>((Map)((HashMap)data).clone());

                    params.set(Util.updateMap(params.get(), "operator", operator));

                    final String newFilter = this.getDrillFilter(params.get());

                    params.set(Util.updateMap(params.get(), "filter", newFilter));

                    synchronized(this) {
                        if (! this.getCellDrillFilters().contains(newFilter)) {
                            this.addCellDrillFilters(newFilter);
                            this.test(params.get());
                        }
                    }
                });
    }

    //**************************************************************************

    private Map<String, String> getDrillTime(final String[] split) {

        final String beginTime = this.getReportTime().get("beginTime");
        final String endTime = this.getReportTime().get("endTime");

        final Map<String, String> beginEndTime = new ConcurrentHashMap<String, String>() {{
            put("startTime", beginTime);
            put("stopTime", endTime);
        }};
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

                        Object index = info.get("concat");

                        originalTime += index == null ? "" : "." + split[(int)index];
                    }

                    final String alteration = info.get(timeField).toString();

                    final String adjustedTime = alteration.isEmpty() ? originalTime :
                            this.getAdjustedTime(alteration, originalTime);

                    beginEndTime.put(timeField, adjustedTime);
                });

        return beginEndTime;
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

            final int count = (Integer)info.get("order");
            final Object isTally = info.get("tally");

            if (isTally != null && isTally.toString().equals("true")) {

                Object tallied = tally.get(column);

                tallied = tallied == null ? 0D : tallied;

                tally.put(column, (double)tallied + Double.valueOf(split[count]));
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

        final Map<String, Object> params = new ConcurrentHashMap(data);

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
                new AtomicReference<>(new CopyOnWriteArrayList<>());

        this.getColumns().entrySet().parallelStream()
                .filter(info -> {

                    final Map<String, Object> value = (Map)info.getValue();

                    return cellDrill == 0 && value.get("filter") != null
                        || cellDrill == (int)value.get("order") && value.get("cellDrill") != null;
                })
                .forEach(info -> {

                    final int count = (int)info.getValue().get("order");

                    final Map<String, Object> params = new ConcurrentHashMap<String, Object>() {{
                        put("filterColumn", info.getKey());
                        put("value", split[count]);
                        put("filterCount", filterCount);
                        put("cellDrill", cellDrill);
                        put("split", split);
                    }};

                    final String filterField = this.checkIfCustomRowFilter() ?
                            this.getRowFilter(params) :
                            this.getCommon().getCommonRowFilter(params);

                    if (! filterField.isEmpty()) {

                        CopyOnWriteArrayList<Map<String, Object>> infoValues =
                                new CopyOnWriteArrayList<>(filterInfo.get());

                        infoValues.add(new ConcurrentHashMap<String, Object>() {{
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

            final int count = (Integer)info.get("order");

            String parent = splitParent[count];
            String drilled = splitLine[count];

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

        final String lineErrorCaption = this.getLineErrorCaption(splitParent);

        final Map<String, String> timeInfo = new ConcurrentHashMap<>();

        this.getColumns().values().stream()
                .filter(dontNeed -> timeInfo.size() < 2)
                .forEach(info -> {

                    final String parent = splitParent[(int)info.get("order")];

                    Stream.of("startTime", "stopTime").parallel()
                            .filter(field -> info.get(field) != null)
                            .forEach(field -> timeInfo.put(field, parent));
                });

        if (timeInfo.size() != 2) {
            return false;
        }

        final String lineStartTime = timeInfo.get("startTime");
        final String lineStopTime = timeInfo.get("stopTime");
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

        return isCaptionPrinted;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private String getLineErrorCaption(final String[] split) {

        AtomicReference<String> caption = new AtomicReference<>("");
        AtomicReference<String> timeRange = new AtomicReference<>("");

        this.getColumns().forEach((column, info) -> {

            final int count = (Integer)info.get("order");

            if (info.get("filter") == null) {
                Stream.of("startTime", "stopTime").parallel()
                        .filter(item -> info.get(item) != null)
                        .forEach(dontNeed -> {

                            String output = Util.getFromTimestamp(split[count]);

                            timeRange.set(timeRange.get() + ", " + column + ": " + output);
                        });
            } else {

                final String prev = caption.get();

                final String comma = prev.isEmpty() ? "" : ", ";

                caption.set(prev + comma + column + " \"" + split[count] + "\"");
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
                    .getDeclaredMethod("getRowFilter", ConcurrentHashMap.class);
        } catch (NoSuchMethodException | SecurityException e) {
            // no need to catch errors
        }

        return isCustomRowFilter != null;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private ConcurrentHashMap<String, Object> handleTestBufferLine(final Map<String, Object> data) {

        final String[] split = (String[])((String[])data.get("split")).clone();
        final boolean isLineMatch = (boolean)data.get("isLineMatch");
        final Map<String, Object> tally = (ConcurrentHashMap)data.get("tally");
        final boolean isCellDrill = data.get("isCellDrill") == null ? false :
                (boolean)data.get("isCellDrill");
        final String[] splitParent = (String[])((String[])data.get("splitParent")).clone();
        final int filterCount = (int)data.get("filterCount");
        final String filter = (String)data.get("filter");
        final int drillLevel = (int)data.get("drillLevel");
        final int lineCount = (int)data.get("lineCount");
        final CopyOnWriteArrayList<String[]> parentLines =
                new CopyOnWriteArrayList((CopyOnWriteArrayList)data.get("parentLines"));

        final String[] tallyOn = splitParent.length > 0 ? splitParent : split;

        final Map<String, Object> tallyParam = isCellDrill ? tally :
                this.tally(tallyOn, tally);

        if (this.getNoDrill() || isCellDrill || ! this.checkIsDrillable()) {
            // some tiles like charts or maps may not be subject to drilling
            return new ConcurrentHashMap<String, Object>() {{
                put("tally", tallyParam);
                put("isLineMatch", isLineMatch);
                put("break", false);
            }};
        }

        if (splitParent.length == 0) {

            final Map<String, String> drillTime = this.getDrillTime(split);

            final String drillTileCmd = this.getReport().getCmd(this, drillTime);
            final String drillCellCmd = this.getReport().getCmd(this);

            final Map<String, Object> params = new HashMap<String, Object>() {{
                put("cmd", drillCellCmd);
                put("split", split);
                put("filter", filter);
                put("filterCount", filterCount);
                put("drillLevel", drillLevel);
                put("parentLines", parentLines);
            }};

            this.drillCell(params);
            // overwriting "cmd" key with a new value for tile drill
            params.put("cmd", drillTileCmd);

            this.drillTile(params);
        } else {

            final boolean isTileSingleLine = this.getIsSingleLine();

            final boolean finalIsLineMatch = this.checkLine(new ConcurrentHashMap<String, Object>() {{
                put("splitLine", split);
                put("splitParent", splitParent);
                put("isTileSingleLine", isTileSingleLine);
                put("lineCount", lineCount);
            }}) || isLineMatch;

            if (! isTileSingleLine && finalIsLineMatch) {
                return new ConcurrentHashMap<String, Object>() {{
                   put("tally", tallyParam);
                   put("isLineMatch", finalIsLineMatch);
                   put("break", true);
               }};
            }
        }

        return new ConcurrentHashMap<String, Object>() {{
            put("tally", tallyParam);
            put("isLineMatch", isLineMatch);
            put("break", false);
        }};
    }

    //**************************************************************************

    private CopyOnWriteArrayList<String[]> getQueryLines(final String finalCmd) {

        final String splitBy = this.getSplitChar();
        final int shift = this.getRemoveFirstItem() ? 1 : 0;
        final CopyOnWriteArrayList<String[]> result = new CopyOnWriteArrayList();

        this.getQueryResults(finalCmd).lines().parallel()
                .forEach(line -> {
                    result.add(Util.split(line.trim(), splitBy, shift));
                });

        return result;
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
    private void checkMatchedLines(final ConcurrentHashMap<String, Object> data) {

        final String[] splitParent = (String[])((String[])data.get("splitParent")).clone();
        final int cellDrill = (int)data.get("cellDrill");
        final String filter = (String)data.get("filter");
        final String operator = data.get("operator") == null ? "" :
                (String)data.get("operator");

        final String columnTitle = this.getColumnTitle(cellDrill);
        final String parentValue = splitParent[cellDrill];

        this.getArrayListIntersection(data).stream().parallel()
                .filter(line -> Util.getBufferLineFilter(line))
                .filter(line -> {

                    final boolean isEqual = this.isEqual(parentValue,
                            line[cellDrill], columnTitle);

                    return operator.isEmpty() == isEqual; // either both (empty and equal) TRUE or both FALSE
                })
                .forEach(line -> {
                    this.logDrilledColumnError(new ConcurrentHashMap<String, Object>() {{
                        put("message", "is missing");
                        put("filter", filter);
                        put("columnOrder", cellDrill);
                        put("line", line);
                    }});
                });
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private CopyOnWriteArrayList<String[]> getArrayListIntersection(final ConcurrentHashMap<String, Object> data) {
        // need to convert to thread safe CopyOnWriteArrayList in order to use removeIf()
        final CopyOnWriteArrayList<String []> parentLines =
                new CopyOnWriteArrayList((CopyOnWriteArrayList)data.get("parentLines"));
        final CopyOnWriteArrayList<String[]> filteredLines =
                new CopyOnWriteArrayList((CopyOnWriteArrayList)data.get("lines"));
        final String[] splitParent = (String[])((String[])data.get("splitParent")).clone();
        final int cellDrill = (int)data.get("cellDrill");
        final String filter = (String)data.get("filter");
        final String operator = data.get("operator") == null ? "" :
                (String)data.get("operator");

        final String parentValue = splitParent[cellDrill];
        final String columnTitle = this.getColumnTitle(cellDrill);

        filteredLines.parallelStream()
                .filter(line -> Util.getBufferLineFilter(line))
                .forEach(line -> {

                    final boolean isEqual = this.isEqual(parentValue,
                            line[cellDrill], columnTitle);

                    if (operator.isEmpty() != isEqual) { // either not empty and equal or empty and not equal
                        this.logDrilledColumnError(new ConcurrentHashMap<String, Object>() {{
                            put("message", "must not have");
                            put("filter", filter);
                            put("columnOrder", cellDrill);
                            put("line", line);
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
    private void logDrilledColumnError(final ConcurrentHashMap<String, Object> data) {

        final String message = (String)data.get("message");
        final String[] line = (String[])((String[])data.get("line")).clone();
        final int columnOrder = (int)data.get("columnOrder");
        final String filter = (String)data.get("filter");

        final String columnTitle = this.getColumnTitle(columnOrder);

        this.logError("\t" + "Query with applied filter '" + filter +
                "' " + message + " a line with '" + columnTitle + "' = " +
                "\"" + line[columnOrder] + "\":");

        this.logError("\t\t" + String.join(this.getSplitChar(), line));
    }

    //**************************************************************************

    private boolean isEqual(final String parent, final String child, String columnTitle) {

        final AtomicReference<Map<String, Object>> info =
                new AtomicReference<>(this.getColumns().get(columnTitle));

        if (info.get().get("equalList") != null) {
            if (child.equals(parent)) {
                return true;
            }
            // check if equalList contains parent
            final AtomicBoolean isParentInList = new AtomicBoolean(
                    Arrays.stream((String[])info.get().get("equalList")).parallel()
                            .anyMatch(value -> value.equals(parent))
            );
            // check if equalList contains child
            final AtomicBoolean isChildInList = new AtomicBoolean(
                    Arrays.stream((String[])info.get().get("equalList")).parallel()
                            .anyMatch(value -> value.equals(child))
            );

            return isParentInList.get() && isChildInList.get();
        } else if (info.get().get("compareLeft") != null && (boolean)info.get().get("compareLeft")) {
            return child.startsWith(parent);
        } else {
            return child.equals(parent);
        }
    }

    //**************************************************************************

    private void checkTallies(final String filter, final Map<String, Object> masterTally) {

        if (masterTally == null) {
            return;
        }

        final Map<String, Map<String, Object>> results = this.getTilesTallies(filter);
        final String error = " with filter \"" + filter + "\" has NO DATA";

        results.keySet().parallelStream()
                .filter(tile -> this.checkIfTallyDiffer(results.get(tile), masterTally))
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

        final Map<String, String> tiles = this.getReport().getTiles();
        final String commonByClassName = this.getCommonByClassName();
        final String masterTitle = this.getTitle();

        final Map<String, Map<String, Object>> results = new HashMap<>();

        final Map<String, Object> params = new HashMap<>();

        params.put("filter", filter);
        params.put("drillLevel", 1);

        tiles.keySet().parallelStream()
                .forEach(tile -> {

                    final Tile testTile = this.getReport().getTileInstance(tile);

                    if (! testTile.getTitle().equals(masterTitle)
                     && testTile.getCommonByClassName().equals(commonByClassName)) {

                        testTile.setNoDrill(true);

                        final Map<String, Map<String, Object>> result =
                                testTile.test(params);

                        results.put(testTile.getTrueName(), result.get("tally"));
                    }
                });

        return results;
    }

    //**************************************************************************

}