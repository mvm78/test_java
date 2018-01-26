package test_java.reports;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import test_java.ErrorsLog;

import test_java.tiles.Tile;
import test_java.tiles.TileFactory;
import test_java.common.Util;

public abstract class Report implements Cloneable {

    private final int maxDrillLevel = 1;

    protected String title;

    protected HashMap<String, ArrayList<String>> tileList;
    protected Map<String, Boolean> skipTiles = new HashMap<>();
    protected String tilesFolder = "";

    private final String beginTime = "18:34:36.945967 06/29/2015";
    private final String endTime = "14:21:00.233799 07/06/2015";
    private final String hashKey = "1";
    private final String appliance = "App5100-30";
    private final String pcap = "testcalls_pure_1_pcap";

    protected String appPath;
    protected String refresh;

    protected Map<String, String> tiles;
    protected HashMap<String, String []> tallyCheck;

    //**************************************************************************

    protected abstract String getTitle();

    //**************************************************************************

    @Override
    public Report clone() throws CloneNotSupportedException {

        try {
            return (Report)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
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

    public String getEndTime() {

        return this.endTime;
    }

    //**************************************************************************

    public String getCmdAppliance() {

        return " U " + this.hashKey +
                " r " + this.appliance +
                " i " + this.pcap;
    }

    //**************************************************************************

    public String getCmdTime() {

        String statTime = Util.getTimeString(this.beginTime);
        String stopTime = Util.getTimeString(this.endTime);

        return " B " + statTime + " E " + stopTime;
    }

    //**************************************************************************

    public String getCmd(Tile tile) {

        String statTime = Util.getTimeString(this.beginTime);
        String stopTime = Util.getTimeString(this.endTime);

        return this.getCmd(tile, statTime, stopTime);
    }

    //**************************************************************************

    public String getCmd(Tile tile, String beginTime, String endTime) {

        String tileAppPath = tile.getAppPath();

        String path = tileAppPath == null ? this.appPath : tileAppPath;

        return path + this.getCmdAppliance() +
                " " + this.refresh +
                " B " + beginTime +
                " E " + endTime;
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

        Map<String, Map<String, Map<String, Object>>> results = new HashMap<>();

        float timeInterval = Util.getTimeInterval(this.beginTime, this.endTime);
        String tileFolder = this.tilesFolder.isEmpty() ? "" : this.tilesFolder + ".";

        this.tiles.forEach((tile, type) -> {

            String className = "test_java.tiles." + type + "." + tileFolder + tile;

            Tile testTile = TileFactory.getTile(className, timeInterval);
            Report report = this;

            Map<String, Object> params = new HashMap<String, Object>() {{
                put("report", report);
                put("filter", filter);
                put("drillLevel", drillLevel);
            }};

            Map<String, Map<String, Object>> result = testTile.test(params);

            result.put("columns", (HashMap)testTile.getColumns());
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

        this.tallyCheck.keySet().stream()
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

        columns.keySet().stream()
                .filter(column -> ((Map)columns.get(column)).get("compare") != null)
                .forEach(column -> {

                    Object toValue = compareToTally.get(column);
                    Object value = compareTally.get(column);

                    if (toValue != null && value != null) {

                        String prettyToValue = Util.getPrettyNumber((double)toValue);
                        String prettyValue = Util.getPrettyNumber((double)value);

                        if (! prettyToValue.equals(prettyValue)) {
                            if (! isCompareToPrined.getAndSet(true)) {
                                ErrorsLog.log("\n" + caption + " tally mismatch:",
                                        logFile);
                            }

                            if (! isComparePrined.getAndSet(true)) {
                                ErrorsLog.log("\t" + compareTitle, logFile);
                            }

                            String error = prettyToValue + " # " + prettyValue;

                            ErrorsLog.log("\t\t" + column + ": " + error, logFile);
                        }
                    }
                });
    }

    //**************************************************************************

    public final void setTiles() {

        this.tiles = new HashMap<String, String>() {};

        this.tileList.forEach((String type, ArrayList<String>typeTiles) -> {
            typeTiles.stream()
                    .filter(tile -> this.skipTiles.get(tile) == null)
                    .forEach(tile -> {
                       this.tiles.put(tile, type);
                    });
        });
    }

    //**************************************************************************

}