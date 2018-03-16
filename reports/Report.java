package test_java.reports;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import test_java.ErrorsLog;
import test_java.common.Consts;
import test_java.tiles.Tile;
import test_java.tiles.TileFactory;
import test_java.common.Util;

public class Report implements Cloneable {

    private final String beginTime = "15:35:00 03/16/2018";
    private final String endTime = "15:35:00.5 03/16/2018";
    private final String hashKey = "1";
    private final String pcap = "em1";
    private final int maxDrillLevel = 1;

    private final AtomicReference<String> title = new AtomicReference<>();
    private final AtomicReference<Map<String, String[]>> tileList = new AtomicReference<>(new HashMap<>());
    private final AtomicReference<Map<String, String[]>> tallyCheck = new AtomicReference<>(new HashMap<>());
    private final AtomicReference<Map<String, Boolean>> skipTiles = new AtomicReference<>(new HashMap<>());
    private final AtomicReference<String> tilesFolder = new AtomicReference<>("");
    private final AtomicReference<String> appPath = new AtomicReference<>();
    private final AtomicReference<String> refresh = new AtomicReference<>("refreshTO 5.0");
    private final AtomicReference<String> interval = new AtomicReference<>();
    private final AtomicReference<Map<String, String>> tiles = new AtomicReference<>(new HashMap<>());

    //**************************************************************************

    private int getMaxDrillLevel() {

        return this.maxDrillLevel;
    }

    //**************************************************************************

    public final String getTitle() {

        return this.title.get();
    }

    //**************************************************************************

    final protected void setTitle(final String title) {

        this.title.set(title);
    }

    //**************************************************************************

    private Map<String, String[]> getTileList() {

        return this.tileList.get();
    }

    //**************************************************************************

    final public String[] getTilesByType(final String type) {

        return this.getTileList().get(type);
    }

    //**************************************************************************

    final protected void setTileList(final ConcurrentHashMap<String, String[]> tileList) {

        this.tileList.set(tileList);
    }

    //**************************************************************************

    private Map<String, String[]> getTallyCheck() {

        return this.tallyCheck.get();
    }

    //**************************************************************************

    final protected void setTallyCheck(final ConcurrentHashMap<String, String[]> tallyCheck) {

        this.tallyCheck.set(tallyCheck);
    }

    //**************************************************************************

    private Map<String, Boolean> getSkipTiles() {

        return this.skipTiles.get();
    }

    //**************************************************************************

    private Boolean getSkipTile(final String skipTile) {

        return this.getSkipTiles().get(skipTile);
    }

    //**************************************************************************

    final public void addSkipTile(final String skipTile) {

        this.skipTiles.set(Util.updateMap(this.skipTiles.get(), skipTile, true));
    }

    //**************************************************************************

    final public void resetSkipTiles() {

        this.skipTiles.set(new ConcurrentHashMap<>());
    }

    //**************************************************************************

    final protected String getTilesFolder() {

        return this.tilesFolder.get();
    }

    //**************************************************************************

    final protected void setTilesFolder(final String tilesFolder) {

        this.tilesFolder.set(tilesFolder);
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

        return this.tiles.get();
    }

    //**************************************************************************

    private void resetTiles() {

        this.tiles.set(new ConcurrentHashMap<String, String>() {});
    }

    //**************************************************************************

    private String getTile(final String type) {

        return this.getTiles().get(type);
    }

    //**************************************************************************

    private void addTile(final String tile, final String type) {

        this.tiles.set(Util.updateMap(this.tiles.get(), tile, type));
    }

    //**************************************************************************

    private String getAppPath() {

        return this.appPath.get();
    }

    //**************************************************************************

    final protected void setAppPath(final String appPath) {

        this.appPath.set(appPath);
    }

    //**************************************************************************

    final protected String getRefresh() {

        return this.refresh.get();
    }

    //**************************************************************************

    final protected void setRefresh(final String refresh) {

        this.refresh.set(refresh);
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
                " r " + this.fetchAppliance(this.pcap) +
                " i " + this.pcap;
    }

    //**************************************************************************

    private String fetchAppliance(final String pcap) {

        final AtomicReference<Process> process = new AtomicReference<>();

        try {
            process.set(Runtime.getRuntime().exec("/usr/local/mercury/bin/vls"));
        } catch (IOException e) {
            System.err.println(Consts.getBrightRed() + "Error running vls");
            System.exit(1);
        }

        final AtomicReference<BufferedReader> stdInput = new AtomicReference<>(
                new BufferedReader(
                        new InputStreamReader(process.get().getInputStream())
                )
        );

        final String line = stdInput.get().lines().parallel()
                .filter(row -> row.substring(row.lastIndexOf('/') + 1).equals(pcap))
                .findFirst()
                .toString();

        return line.substring(0, line.lastIndexOf('/'))
                .replace("Optional[", "");
    }

    //**************************************************************************

    public String getCmdTime() {

        return " B " + Util.getTimeStamp(this.beginTime) +
               " E " + Util.getTimeStamp(this.endTime);
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

        this.interval.set(Util.getTimeInterval(this.getBeginTime(), this.getEndTime()));
    }

    //**************************************************************************

    public final String getInterval() {

        return this.interval.get();
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