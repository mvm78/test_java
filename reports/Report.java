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

    private final int maxDrillLevel = 1;

    protected String title;

    protected HashMap<String, String []> tileList;
    protected Map<String, Boolean> skipTiles = new HashMap<>();
    protected String tilesFolder = "";

    private final String beginTime = "08:40:00 02/02/2018";
    private final String endTime = "08:40:01 02/02/2018";
    private final String hashKey = "1";
    private final String appliance = "App5100-30";
    private final String pcap = "nf0";

    protected String appPath;
    protected String refresh;

    protected Map<String, String> tiles;
    protected HashMap<String, String []> tallyCheck;

    //**************************************************************************

    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    //**************************************************************************

    public void addSkipTile(String skipTile) {

        this.skipTiles.put(skipTile, true);
    }

    //**************************************************************************

    public void resetSkipTiles() {

        this.skipTiles = new HashMap<>();
    }

    //**************************************************************************

    public String getBeginTime() {

        return this.beginTime;
    }

    //**************************************************************************

    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

    public String getEndTime() {

        return this.endTime;
    }

    //**************************************************************************

    public Map<String, String> getTiles() {

        return this.tiles;
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

        String path = tileAppPath == null ? this.appPath : tileAppPath;

        return path + this.getCmdAppliance() +
                " " + this.refresh +
                " B " + drillTime.get("startTime") +
                " E " + drillTime.get("stopTime");
    }

    //**************************************************************************

    public void tests() {

        this.tests(1, "");
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public void tests(int drillLevel, String filter) {

        if (drillLevel > this.maxDrillLevel) {
            return;
        }

        Report report = this;
        Map<String, Map<String, Map<String, Object>>> results = new HashMap<>();

        float timeInterval = Util.getTimeInterval(this.beginTime, this.endTime);
        String tileFolder = this.tilesFolder.isEmpty() ? "" : this.tilesFolder + ".";

        String reportBeginTime = this.getBeginTime();
        String reportEndTime = this.getEndTime();

        Map<String, String> reportTime = new HashMap<String, String>() {{
            put("beginTime", Util.getTimeStamp(reportBeginTime));
            put("endTime", Util.getTimeStamp(reportEndTime));
            put("beginTimeString", reportBeginTime);
            put("endTimeString", reportEndTime);
        }};

        Map<String, Object> params = new HashMap<String, Object>() {{
            put("report", report);
            put("filter", filter);
            put("drillLevel", drillLevel);
        }};

        this.tiles.keySet().parallelStream()
                .forEach(tile -> {

                    String type = this.tiles.get(tile);

                    String className = "test_java.tiles." + type + "." + tileFolder + tile;

                    Tile testTile = TileFactory.getTile(className, timeInterval);

                    Util.setPoperty(testTile, "report", this);
                    Util.setPoperty(testTile, "reportTime", reportTime);

                    Map<String, Map<String, Object>> result = testTile.test(params);

                    result.put("columns", (Map)testTile.getColumns());
                    result.put("info", new HashMap<String, Object>() {{
                        put("title", testTile.getTitle());
                    }});

                    results.put(testTile.getTrueName(), result);
                });

        if (this.tallyCheck != null) {
            this.checkTally(results, filter);
        }
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void checkTally(
            Map<String, Map<String, Map<String, Object>>> results,
            String filter
    ) {

        this.tallyCheck.keySet().parallelStream()
                .filter(tile -> results.get(tile) != null)
                .forEach(tile -> {

                    Map<String, Map<String, Object>> compareToData = results.get(tile);

                    String text = compareToData.get("info").get("title").toString();

                    text += filter.isEmpty() ? "" : " with filter \"" + filter + "\"";

                    AtomicReference<String> caption = new AtomicReference<>(text);
                    AtomicBoolean isCompareToPrined = new AtomicBoolean(false);

                    Arrays.stream(this.tallyCheck.get(tile))
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

        this.tiles = new HashMap<String, String>() {};

        this.tileList.keySet().parallelStream()
                .forEach(type -> {

                    String [] typeTiles = this.tileList.get(type);

                    Arrays.stream(typeTiles).parallel()
                            .filter(tile -> this.skipTiles.get(tile) == null)
                            .forEach(tile -> {
                                this.tiles.put(tile, type);
                            });
                });
    }

    //**************************************************************************

}