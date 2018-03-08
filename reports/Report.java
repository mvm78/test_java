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

    private final String beginTime = "10:52:43.484002 06/05/2017";
    private final String endTime = "10:52:44 03/01/2018";
    private final String hashKey = "1";
//    private final String appliance = "securityeng164";
//    private final String appliance = "A-5110-Dev-30";
    private final String appliance = "App5100-30";
//    private final String appliance = "Appliance-PM_Perf";
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
    private Map<String, String> tiles = new HashMap<>();

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

        final AtomicReference<Map<String, Map<String, Map<String, Object>>>> results =
                new AtomicReference<>(new HashMap<>());

        final AtomicReference<Map<String, Object>> params = new AtomicReference<>(
                new HashMap<String, Object>() {{
                    put("filter", filter);
                    put("drillLevel", drillLevel);
                }}
        );

        this.setInterval();

        this.getTiles().keySet().parallelStream()
                .forEach(tile -> {

                    final Tile testTile = this.getTileInstance(tile);

                    final AtomicReference<Map<String, Map<String, Object>>> result =
                            new AtomicReference<>(testTile.test(params.get()));

                    result.set(Util.updateMap(result.get(), "columns", (Map)testTile.getColumns()));
                    result.set(Util.updateMap(result.get(), "info",
                            new HashMap<String, Object>() {{
                                put("title", testTile.getTitle());
                            }})
                    );

                    final String trueName = testTile.getTrueName();

                    results.set(Util.updateMap(results.get(), trueName, result.get()));
                });

        if (this.getTallyCheck() != null) {
            this.checkTally(results.get(), filter);
        }
    }

    //**************************************************************************

    private void checkTally(
            final Map<String, Map<String, Map<String, Object>>> results,
            final String filter
    ) {

        this.getTallyCheck().keySet().parallelStream()
                .filter(tile -> results.get(tile) != null)
                .forEach(tile -> {
                    this.checkTallyExecute(results, filter, tile);
                });
    }

    //**************************************************************************

    private void checkTallyExecute(
            final Map<String, Map<String, Map<String, Object>>> results,
            final String filter,
            final String tile
    ) {

        final AtomicReference<String[]> checkTile =
                new AtomicReference<>(this.getTallyCheck().get(tile));
        AtomicBoolean isCompareToPrinted = new AtomicBoolean(false);

        final String description = filter.isEmpty() ? "" :
                " with filter \"" + filter + "\"";

        final String caption = results.get(tile).get("info").get("title").toString() +
                description;

        Arrays.stream(checkTile.get())
                .filter(item -> results.get(item) != null)
                .forEach(item -> {
                    this.compareTallies(results.get(tile), (Map)results.get(item),
                            isCompareToPrinted, caption);
                });
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void compareTallies(
            final Map<String, Map<String, Object>> compareToTile,
            final Map<String, Map<String, Object>> compareTile,
            AtomicBoolean isCompareToPrinted,
            final String caption
    ) {

        AtomicBoolean isComparePrinted = new AtomicBoolean(false);

        final AtomicReference<Map<String, Object>> columns =
                new AtomicReference<>(compareToTile.get("columns"));
        final AtomicReference<Map<String, Object>> compareToTally =
                new AtomicReference<>(compareToTile.get("tally"));
        final AtomicReference<Map<String, Object>> compareTally =
                new AtomicReference<>(compareTile.get("tally"));

        final String logFile = "tallyErrors.log";
        final String compareTitle = compareTile.get("info").get("title").toString();

        columns.get().keySet().stream().parallel()
                .filter(column -> ((Map)columns.get().get(column)).get("compare") != null)
                .filter(column -> compareToTally.get().get(column) != null)
                .filter(column -> compareTally.get().get(column) != null)
                .forEach(column -> {

                    final String prettyToValue =
                            Util.getPrettyNumber(compareToTally.get().get(column));
                    final String prettyValue =
                            Util.getPrettyNumber(compareTally.get().get(column));

                    if (! prettyToValue.equals(prettyValue)) {
                        if (! isCompareToPrinted.getAndSet(true)) {
                            ErrorsLog.log("\n" + caption + " tally mismatch:", logFile);
                        }

                        if (! isComparePrinted.getAndSet(true)) {
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

                    final AtomicReference<String[]> typeTiles =
                            new AtomicReference<>(this.getTilesByType(type));

                    Arrays.stream(typeTiles.get()).parallel()
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

        final Tile tile = TileFactory.getTile(className, timeInterval);

        tile.setReport(this);
        tile.setReportTime(new HashMap<String, String>() {{
            put("interval", Util.getTimeInterval(startTime, stopTime));
            put("beginTime", Util.getTimeStamp(startTime));
            put("endTime", Util.getTimeStamp(stopTime));
            put("beginTimeString", startTime);
            put("endTimeString", stopTime);
        }});

        return tile;
    }

    //**************************************************************************

}