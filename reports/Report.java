package test_java.reports;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import test_java.ErrorsLog;
import test_java.common.Consts;
import test_java.tiles.Tile;
import test_java.tiles.TileFactory;
import test_java.common.Util;

public class Report implements Cloneable {

    private final String beginTime = "10:50:00 02/15/2018";
    private final String endTime = "10:50:03 02/15/2018";
    private final String hashKey = "1";
    private final String appliance = "securityeng164";
    private final String pcap = "em1";
    private final int maxDrillLevel = 1;

    private String title;
    private Map<String, String[]> tileList;
    private Map<String, String[]> tallyCheck;
    private Map<String, Boolean> skipTiles = new HashMap<>();
    private String tilesFolder = "";
    private String appPath;
    private String refresh = "refreshTO 5.0";
    private String interval;
    private Map<String, String> tiles;

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

    final protected void setTileList(final HashMap<String, String[]> tileList) {

        this.tileList = tileList;
    }

    //**************************************************************************

    private Map<String, String[]> getTallyCheck() {

        return this.tallyCheck;
    }

    //**************************************************************************

    final protected void setTallyCheck(final HashMap<String, String[]> tallyCheck) {

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

        this.skipTiles = new HashMap<>();
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

        this.tiles = new HashMap<String, String>() {};
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

        return this.getCmd(tile, new HashMap<String, String>() {{
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

        final Map<String, Map<String, Map<String, Object>>> results = new HashMap<>();

        final Map<String, Object> params = new HashMap<String, Object>() {{
            put("filter", filter);
            put("drillLevel", drillLevel);
        }};

        this.setInterval();

        this.getTiles().keySet().parallelStream()
                .forEach(tile -> {

                    final Tile testTile = this.getTileInstance(tile);

                    final Map<String, Map<String, Object>> result =
                            testTile.test(params);

                    result.put("columns", (Map)testTile.getColumns());
                    result.put("info", new HashMap<String, Object>() {{
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
            final Map<String, Map<String, Map<String, Object>>> results,
            final String filter
    ) {

        this.getTallyCheck().keySet().parallelStream()
                .filter(tile -> results.get(tile) != null)
                .forEach(tile -> {

                    final String[] checkTile = this.getTallyCheck().get(tile);
                    AtomicBoolean isCompareToPrined = new AtomicBoolean(false);
                    final Map<String, Map<String, Object>> compareToData =
                            results.get(tile);
                    final String description = filter.isEmpty() ? "" :
                            " with filter \"" + filter + "\"";

                    final String caption =
                            compareToData.get("info").get("title").toString() + description;

                    Arrays.stream(checkTile)
                            .filter(item -> results.get(item) != null)
                            .forEach(item -> {
                                this.compareTallies(compareToData, (Map)results.get(item),
                                        isCompareToPrined, caption);
                            });
                });
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void compareTallies(
            final Map<String, Map<String, Object>> compareToTile,
            final Map<String, Map<String, Object>> compareTile,
            AtomicBoolean isCompareToPrined,
            final String caption
    ) {

        AtomicBoolean isComparePrined = new AtomicBoolean(false);

        final Map<String, Object> columns = compareToTile.get("columns");
        final Map<String, Object> compareToTally = compareToTile.get("tally");
        final Map<String, Object> compareTally = compareTile.get("tally");

        final String logFile = "tallyErrors.log";
        final String compareTitle = compareTile.get("info").get("title").toString();

        columns.keySet().stream().parallel()
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

        this.getTileList().keySet().parallelStream()
                .forEach(type -> {

                    final String[] typeTiles = this.getTilesByType(type);

                    Arrays.stream(typeTiles).parallel()
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

        final Map<String, String> reportTime = new HashMap<String, String>() {{
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