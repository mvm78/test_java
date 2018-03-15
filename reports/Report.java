package test_java.reports;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import test_java.ErrorsLog;
import test_java.common.Consts;
import test_java.tiles.Tile;
import test_java.tiles.TileFactory;
import test_java.common.Util;

public class Report implements Cloneable {

    private final String beginTime = "11:00:00 03/15/2018";
    private final String endTime = "11:00:00.1 03/15/2018";
    private final String hashKey = "1";
//    private final String appliance = "A-5120-Nightly-42";
    private final String appliance = "securityeng164";
//    private final String appliance = "A-5110-Dev-30";
//    private final String appliance = "App5100-30";
//    private final String appliance = "Appliance-PM_Perf";
    private final String pcap = "em1";
    private final int maxDrillLevel = 1;

    private String title;
    private Map<String, String[]> tileList = new ConcurrentHashMap<>();
    private Map<String, String[]> tallyCheck = new ConcurrentHashMap<>();
    private Map<String, Boolean> skipTiles = new ConcurrentHashMap<>();
    private String tilesFolder = "";
    private String appPath;
    private String refresh = "refreshTO 5.0";
    private String interval;
    private Map<String, String> tiles = new ConcurrentHashMap<>();

    //**************************************************************************

    private int getMaxDrillLevel() {

        return this.maxDrillLevel;
    }

    //**************************************************************************

    public final String getTitle() {

        return this.title;
    }

    //**************************************************************************

    final protected void setTitle(final String title) {

        this.title = title;
    }

    //**************************************************************************

    private Map<String, String[]> getTileList() {

        return this.tileList;
    }

    //**************************************************************************

    final public String[] getTilesByType(final String type) {

        return this.getTileList().get(type);
    }

    //**************************************************************************

    final protected void setTileList(final ConcurrentHashMap<String, String[]> tileList) {

        this.tileList = tileList;
    }

    //**************************************************************************

    private Map<String, String[]> getTallyCheck() {

        return this.tallyCheck;
    }

    //**************************************************************************

    final protected void setTallyCheck(final ConcurrentHashMap<String, String[]> tallyCheck) {

        this.tallyCheck = tallyCheck;
    }

    //**************************************************************************

    private Map<String, Boolean> getSkipTiles() {

        return this.skipTiles;
    }

    //**************************************************************************

    private Boolean getSkipTile(final String skipTile) {

        return this.getSkipTiles().get(skipTile);
    }

    //**************************************************************************

    final public void addSkipTile(final String skipTile) {

        this.skipTiles.put(skipTile, true);
    }

    //**************************************************************************

    final public void resetSkipTiles() {

        this.skipTiles = new ConcurrentHashMap<>();
    }

    //**************************************************************************

    final protected String getTilesFolder() {

        return this.tilesFolder;
    }

    //**************************************************************************

    final protected void setTilesFolder(final String tilesFolder) {

        this.tilesFolder = tilesFolder;
    }

    //**************************************************************************

    private String getBeginTime() {

        return this.beginTime;
    }

    //**************************************************************************

    private String getEndTime() {

        return this.endTime;
    }

    //**************************************************************************

    final public Map<String, String> getTiles() {

        return this.tiles;
    }

    //**************************************************************************

    private void resetTiles() {

        this.tiles = new ConcurrentHashMap<String, String>() {};
    }

    //**************************************************************************

    private String getTile(final String type) {

        return this.getTiles().get(type);
    }

    //**************************************************************************

    private void addTile(final String tile, final String type) {

        this.tiles.put(tile, type);
    }

    //**************************************************************************

    private String getAppPath() {

        return this.appPath;
    }

    //**************************************************************************

    final protected void setAppPath(final String appPath) {

        this.appPath = appPath;
    }

    //**************************************************************************

    final protected String getRefresh() {

        return this.refresh;
    }

    //**************************************************************************

    final protected void setRefresh(final String refresh) {

        this.refresh = refresh;
    }

    //**************************************************************************

    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public Report cloneReport() {

        Report report = null;

        try {
            report = (Report)this.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println(Consts.getBrightRed() + "Error cloning report");
            System.exit(1);
        }

        if (report == null) {
            System.err.println(Consts.getBrightRed() + "Error cloning report");
            System.exit(1);
        }

        return report;
    }

    //**************************************************************************

    public String getCmdAppliance() {

        return " U " + this.hashKey +
                " r " + this.appliance +
                " i " + this.pcap;
    }

    //**************************************************************************

    public String getCmdTime() {

        final String startTime = Util.getTimeStamp(this.beginTime);
        final String stopTime = Util.getTimeStamp(this.endTime);

        return " B " + startTime + " E " + stopTime;
    }

    //**************************************************************************

    public String getCmd(Tile tile) {

        final String startTime = Util.getTimeStamp(this.beginTime);
        final String stopTime = Util.getTimeStamp(this.endTime);

        return this.getCmd(tile, new ConcurrentHashMap<String, String>() {{
            put("startTime", startTime);
            put("stopTime", stopTime);
        }});
    }

    //**************************************************************************

    public String getCmd(final Tile tile, final Map<String, String> drillTime) {

        final String tileAppPath = tile.getAppPath();

        final String path = tileAppPath == null ? this.getAppPath() : tileAppPath;

        return path + this.getCmdAppliance() +
                " " + this.getRefresh() +
                " B " + drillTime.get("startTime") +
                " E " + drillTime.get("stopTime");
    }

    //**************************************************************************

    public final void setInterval() {

        this.interval = Util.getTimeInterval(this.getBeginTime(), this.getEndTime());
    }

    //**************************************************************************

    public final String getInterval() {

        return this.interval;
    }

    //**************************************************************************

    public void tests() {

        this.tests(1, "");
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public void tests(final int drillLevel, final String filter) {

        if (this.getMaxDrillLevel() < drillLevel) {
            return;
        }

        final Map<String, ConcurrentHashMap<String, Map<String, Object>>> results = new ConcurrentHashMap<>();

        final ConcurrentHashMap<String, Object> params = new ConcurrentHashMap<>();

        params.put("filter", filter);
        params.put("drillLevel", drillLevel);

        this.setInterval();

        this.getTiles().keySet().stream() // .parallelStream()
                .forEach(tile -> {

                    final Tile testTile = this.getTileInstance(tile);

                    final ConcurrentHashMap<String, Map<String, Object>> result =
                            new ConcurrentHashMap(testTile.test(params));

                    result.put("columns", (LinkedHashMap)testTile.getColumns());
                    result.put("info", new ConcurrentHashMap<String, Object>() {{
                        put("title", testTile.getTitle());
                    }});

                    results.put(testTile.getTrueName(), result);
                });

        if (this.getTallyCheck() != null) {
            this.checkTally(results, filter);
        }
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void checkTally(
            final Map<String, ConcurrentHashMap<String, Map<String, Object>>> results,
            final String filter
    ) {

        this.getTallyCheck().keySet().stream() // .parallelStream()
                .filter(tile -> results.get(tile) != null)
                .forEach(tile -> {

                    final String[] checkTile = this.getTallyCheck().get(tile);
                    AtomicBoolean isCompareToPrined = new AtomicBoolean(false);
                    final ConcurrentHashMap<String, Map<String, Object>> compareToData =
                            results.get(tile);
                    final String description = filter.isEmpty() ? "" :
                            " with filter \"" + filter + "\"";

                    final String caption =
                            compareToData.get("info").get("title").toString() + description;

                    Arrays.stream(checkTile)
                            .filter(item -> results.get(item) != null)
                            .forEach(item -> {
                                this.compareTallies(compareToData, (ConcurrentHashMap)results.get(item),
                                        isCompareToPrined, caption);
                            });
                });
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void compareTallies(
            final ConcurrentHashMap<String, Map<String, Object>> compareToTile,
            final ConcurrentHashMap<String, Map<String, Object>> compareTile,
            AtomicBoolean isCompareToPrined,
            final String caption
    ) {

        AtomicBoolean isComparePrined = new AtomicBoolean(false);

        final Map<String, Object> columns = compareToTile.get("columns");
        final Map<String, Object> compareToTally = compareToTile.get("tally");
        final Map<String, Object> compareTally = compareTile.get("tally");

        final String logFile = "tallyErrors.log";
        final String compareTitle = compareTile.get("info").get("title").toString();

        columns.keySet().stream() // .parallel()
                .filter(column -> ((Map)columns.get(column)).get("compare") != null)
                .filter(column -> compareToTally.get(column) != null)
                .filter(column -> compareTally.get(column) != null)
                .forEach(column -> {

                    final String prettyToValue =
                            Util.getPrettyNumber(compareToTally.get(column));
                    final String prettyValue =
                            Util.getPrettyNumber(compareTally.get(column));

                    if (! prettyToValue.equals(prettyValue)) {
                        if (! isCompareToPrined.getAndSet(true)) {
                            ErrorsLog.log("\n" + caption + " tally mismatch:", logFile);
                        }

                        if (! isComparePrined.getAndSet(true)) {
                            ErrorsLog.log("\t" + compareTitle, logFile);
                        }

                        final String error = prettyToValue + " # " + prettyValue;

                        ErrorsLog.log("\t\t" + column + ": " + error, logFile);
                    }
                });
    }

    //**************************************************************************

    public final void setTiles() {

        this.resetTiles();

        this.getTileList().keySet().stream() // .parallelStream()
                .forEach(type -> {

                    final String[] typeTiles = this.getTilesByType(type);

                    Arrays.stream(typeTiles) // .parallel()
                            .filter(tile -> this.getSkipTile(tile) == null)
                            .forEach(tile -> this.addTile(tile, type));
                });
    }

    //**************************************************************************

    public final String setTileClassFullName(final String tile) {

        final String tileFolder = this.getTilesFolder().isEmpty() ? "" :
                this.getTilesFolder() + ".";
        final String type = this.getTile(tile);

        return "test_java.tiles." + type + "." + tileFolder + tile;
    }

    //**************************************************************************

    public final Tile getTileInstance(final String tileName) {

        final float timeInterval = Float.valueOf(this.getInterval());
        final String className = this.setTileClassFullName(tileName);

        final String startTime = this.getBeginTime();
        final String stopTime = this.getEndTime();

        final Map<String, String> reportTime = new ConcurrentHashMap<String, String>() {{
            put("interval", Util.getTimeInterval(startTime, stopTime));
            put("beginTime", Util.getTimeStamp(startTime));
            put("endTime", Util.getTimeStamp(stopTime));
            put("beginTimeString", startTime);
            put("endTimeString", stopTime);
        }};

        final Tile tile = TileFactory.getTile(className, timeInterval);

        tile.setReport(this);
        tile.setReportTime(reportTime);

        return tile;
    }

    //**************************************************************************

}