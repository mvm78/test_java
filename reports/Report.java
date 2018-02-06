package test_java.reports;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import test_java.ErrorsLog;
import test_java.common.Consts;
import test_java.tiles.Tile;
import test_java.tiles.TileFactory;
import test_java.common.Util;

public class Report implements Cloneable {

    private final String beginTime = "12:00:00 02/06/2018";
    private final String endTime = "12:00:20 02/06/2018";
    private final String hashKey = "1";
    private final String appliance = "Appliance-PM_Perf";
    private final String pcap = "em1";
    private final int maxDrillLevel = 1;

    private String title;
    private Map<String, String []> tileList;
    private Map<String, String []> tallyCheck;
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

    final protected void setTitle(String title) {

        this.title = title;
    }

    //**************************************************************************

    private Map<String, String []> getTileList() {

        return this.tileList;
    }

    //**************************************************************************

    final public String [] getTilesByType(String type) {

        return this.getTileList().get(type);
    }

    //**************************************************************************

    final protected void setTileList(HashMap<String, String []> tileList) {

        this.tileList = tileList;
    }

    //**************************************************************************

    private Map<String, String []> getTallyCheck() {

        return this.tallyCheck;
    }

    //**************************************************************************

    final protected void setTallyCheck(HashMap<String, String []> tallyCheck) {

        this.tallyCheck = tallyCheck;
    }

    //**************************************************************************

    private Map<String, Boolean> getSkipTiles() {

        return this.skipTiles;
    }

    //**************************************************************************

    private Boolean getSkipTile(String skipTile) {

        return this.getSkipTiles().get(skipTile);
    }

    //**************************************************************************

    final public void addSkipTile(String skipTile) {

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

    final protected void setTilesFolder(String tilesFolder) {

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

    private String getTile(String type) {

        return this.getTiles().get(type);
    }

    //**************************************************************************

    private void addTile(String tile, String type) {

        this.tiles.put(tile, type);
    }

    //**************************************************************************

    private String getAppPath() {

        return this.appPath;
    }

    //**************************************************************************

    final protected void setAppPath(String appPath) {

        this.appPath = appPath;
    }

    //**************************************************************************

    final protected String getRefresh() {

        return this.refresh;
    }

    //**************************************************************************

    final protected void setRefresh(String refresh) {

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
            System.err.println(Consts.BRIGHT_RED + "Error cloning report");
            System.exit(1);
        }

        if (report == null) {
            System.err.println(Consts.BRIGHT_RED + "Error cloning report");
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

        String startTime = Util.getTimeStamp(this.beginTime);
        String stopTime = Util.getTimeStamp(this.endTime);

        return " B " + startTime + " E " + stopTime;
    }

    //**************************************************************************

    public String getCmd(Tile tile) {

        String startTime = Util.getTimeStamp(this.beginTime);
        String stopTime = Util.getTimeStamp(this.endTime);

        return this.getCmd(tile, new HashMap<String, String>() {{
            put("startTime", startTime);
            put("stopTime", stopTime);
        }});
    }

    //**************************************************************************

    public String getCmd(Tile tile, Map<String, String> drillTime) {

        String tileAppPath = tile.getAppPath();

        String path = tileAppPath == null ? this.getAppPath() : tileAppPath;

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
    public void tests(int drillLevel, String filter) {

        if (this.getMaxDrillLevel() < drillLevel) {
            return;
        }

        Map<String, Map<String, Map<String, Object>>> results = new HashMap<>();

        Map<String, Object> params = new HashMap<String, Object>() {{
            put("filter", filter);
            put("drillLevel", drillLevel);
        }};

        this.setInterval();

        this.getTiles().keySet().parallelStream()
                .forEach(tile -> {

                    Tile testTile = this.getTileInstance(tile);

                    Map<String, Map<String, Object>> result = testTile.test(params);

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
            Map<String, Map<String, Map<String, Object>>> results,
            String filter
    ) {

        this.getTallyCheck().keySet().parallelStream()
                .filter(tile -> results.get(tile) != null)
                .forEach(tile -> {

                    Map<String, Map<String, Object>> compareToData = results.get(tile);

                    String text = compareToData.get("info").get("title").toString();

                    text += filter.isEmpty() ? "" : " with filter \"" + filter + "\"";

                    AtomicReference<String> caption = new AtomicReference<>(text);
                    AtomicBoolean isCompareToPrined = new AtomicBoolean(false);

                    String [] checkTile = this.getTallyCheck().get(tile);

                    Arrays.stream(checkTile)
                            .filter(item -> results.get(item) != null)
                            .forEach(item -> {
                                this.compareTallies(compareToData, (Map)results.get(item),
                                        isCompareToPrined, caption);
                            });
                });
    }

    //**************************************************************************

    private void compareTallies(
            Map<String, Map<String, Object>> compareToTile,
            Map<String, Map<String, Object>> compareTile,
            AtomicBoolean isCompareToPrined,
            AtomicReference<String> caption
    ) {

        AtomicBoolean isComparePrined = new AtomicBoolean(false);

        Map<String, Object> columns = compareToTile.get("columns");
        Map<String, Object> compareToTally = compareToTile.get("tally");
        Map<String, Object> compareTally = compareTile.get("tally");

        String logFile = "tallyErrors.log";
        String compareTitle = compareTile.get("info").get("title").toString();

        columns.keySet().stream().parallel()
                .filter(column -> ((Map)columns.get(column)).get("compare") != null)
                .filter(column -> compareToTally.get(column) != null)
                .filter(column -> compareTally.get(column) != null)
                .forEach(column -> {

                    String prettyToValue = Util.getPrettyNumber(compareToTally.get(column));
                    String prettyValue = Util.getPrettyNumber(compareTally.get(column));

                    if (! prettyToValue.equals(prettyValue)) {
                        if (! isCompareToPrined.getAndSet(true)) {
                            ErrorsLog.log("\n" + caption + " tally mismatch:", logFile);
                        }

                        if (! isComparePrined.getAndSet(true)) {
                            ErrorsLog.log("\t" + compareTitle, logFile);
                        }

                        String error = prettyToValue + " # " + prettyValue;

                        ErrorsLog.log("\t\t" + column + ": " + error, logFile);
                    }
                });
    }

    //**************************************************************************

    public final void setTiles() {

        this.resetTiles();

        this.getTileList().keySet().parallelStream()
                .forEach(type -> {

                    String [] typeTiles = this.getTilesByType(type);

                    Arrays.stream(typeTiles).parallel()
                            .filter(tile -> this.getSkipTile(tile) == null)
                            .forEach(tile -> {
                                this.addTile(tile, type);
                            });
                });
    }

    //**************************************************************************

    public final String setTileClassFullName(String tile) {

        String tileFolder = this.getTilesFolder().isEmpty() ? "" :
                this.getTilesFolder() + ".";
        String type = this.getTile(tile);

        return "test_java.tiles." + type + "." + tileFolder + tile;
    }

    //**************************************************************************

    public final Tile getTileInstance(String tileName) {

        float timeInterval = Float.valueOf(this.getInterval());
        String className = this.setTileClassFullName(tileName);

        String startTime = this.getBeginTime();
        String stopTime = this.getEndTime();

        Map<String, String> reportTime = new HashMap<String, String>() {{
            put("interval", Util.getTimeInterval(startTime, stopTime));
            put("beginTime", Util.getTimeStamp(startTime));
            put("endTime", Util.getTimeStamp(stopTime));
            put("beginTimeString", startTime);
            put("endTimeString", stopTime);
        }};

        Tile tile = TileFactory.getTile(className, timeInterval);

        tile.setReport(this);
        tile.setReportTime(reportTime);

        return tile;
    }

    //**************************************************************************

}