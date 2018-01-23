package test_java.reports;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import test_java.ErrorsLog;

import test_java.tiles.Tile;
import test_java.tiles.TileFactory;
import test_java.common.Util;

public abstract class Report implements Cloneable {

    private final int maxDrillLevel = 1;

    protected String title;

    protected HashMap<String, ArrayList<String>> tileList;
    protected HashMap<String, Boolean> skipTiles = new HashMap<>();
    protected String tilesFolder = "";

    private final String beginTime = "14:00:00 01/23/2018";
    private final String endTime = "14:00:20 01/23/2018";
    private final String hashKey = "1";
    private final String appliance = "App5100-30";
    private final String pcap = "em1";

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

    protected LinkedHashMap<String, Map<String, Map<String, Object>>> runTileTests(
            String [] classNames
    ) {

        return this.runTileTests(classNames, 1, "");
    }

    //**************************************************************************

    protected LinkedHashMap<String, Map<String, Map<String, Object>>> runTileTests(
            String [] classNames,
            int drillLevel,
            String filter
    ) {

        float timeInterval = Util.getTimeInterval(this.beginTime, this.endTime);

        LinkedHashMap<String, Map<String, Map<String, Object>>> results =
                new LinkedHashMap<>();

        for (String className: classNames) {

            Tile tile = TileFactory.getTile(className, timeInterval);

            if (tile != null) {

                String classTrueName = tile.getTrueName();
                Map<String, Map<String, Object>> tileResults =
                        this.runTileTest(tile, filter, drillLevel);

                results.put(classTrueName, tileResults);
            }
        }

        return results;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private Map<String, Map<String, Object>> runTileTest(
            Tile tile,
            String filter,
            int drillLevel
    ) {

        Report report = this;

        Map<String, Object> params = new HashMap<String, Object>() {{
            put("report", report);
            put("filter", filter);
            put("drillLevel", drillLevel);
        }};

        Map<String, Map<String, Object>> result = tile.test(params);

        result.put("columns", (HashMap)tile.getColumns());
        result.put("info", new HashMap<String, Object>() {{
            put("title", tile.getTitle());
        }});

        return result;
    }

    //**************************************************************************

    public void tests() {

        this.tests(1, "");
    }

    //**************************************************************************

    public void tests(int drillLevel, String filter) {

        if (drillLevel > this.maxDrillLevel) {
            return;
        }

        ArrayList<String> testTiles = new ArrayList<>();

        String tileFolder = this.tilesFolder.isEmpty() ? "" :
                this.tilesFolder + ".";

        this.tiles.forEach((tile, type) -> {
            testTiles.add("test_java.tiles." + type + "." + tileFolder + tile);
        });

        String [] classNames = testTiles.toArray(new String[0]);

        LinkedHashMap<String, Map<String, Map<String, Object>>> results =
                this.runTileTests(classNames, drillLevel, filter);

        this.checkTally(results, filter);
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void checkTally(
            LinkedHashMap<String, Map<String, Map<String, Object>>> results,
            String filter
    ) {

        if (this.tallyCheck == null) {
            return;
        }

        this.tallyCheck.forEach((compareToTile, compareTiles) -> {
            // loop through parent ("compareTo" tiles)
            Map<String, Map<String, Object>> compareToData =
                    results.get(compareToTile);

            if (compareToData == null) {
                // continue the loop if "results" returned NO DATA
                return;
            }

            AtomicBoolean isCompareToPrined = new AtomicBoolean(false);

            String compareToTitle = compareToData.get("info").get("title").toString();

            for (byte count=0; count<compareTiles.length; count++) {
                // loop through child ("compare") tiles
                Map<String, Map<String, Object>> compareTile =
                        (HashMap)results.get(compareTiles[count]);

                if (compareTile == null) {
                    continue;
                }
                // compare column tallies
                this.compareTallies(compareToData, compareTile, isCompareToPrined,
                        compareToTitle, filter);
            }
        });
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    private void compareTallies(
            Map<String, Map<String, Object>> compareToData,
            Map<String, Map<String, Object>> compareTile,
            AtomicBoolean isCompareToPrined,
            String compareToTitle,
            String filter
    ) {

        AtomicBoolean isComparePrined = new AtomicBoolean(false);

        String compareTitle = compareTile.get("info").get("title").toString();

        compareToData.get("columns").forEach((column, columnInfo) -> {
            // loop through columns in parent ("compareTo") tile
            HashMap<String, String> info = (HashMap)columnInfo;

            if (info.get("compare") == null) {
                // skip missing or not compareble fields
                return;
            }

            Object compareTo = compareToData.get("tally").get(column);
            Object compare = compareTile.get("tally").get(column);

            if (compareTo == null || compare == null) {
                return;
            }

            double compareToValue = (double)compareTo;
            double compareValue = (double)compare;

            if (compareValue != compareToValue) {
                if (! isCompareToPrined.getAndSet(true)) {

                    String filterSuffix = filter.isEmpty() ? "" :
                            " with filter \"" + filter + "\"";

                    ErrorsLog.log("\n" + compareToTitle + filterSuffix + " tally mismatch:",
                            "tallyErrors.log");
                }

                if (! isComparePrined.getAndSet(true)) {
                    ErrorsLog.log("\t" + compareTitle, "tallyErrors.log");
                }

                String error = Util.getPrettyNumber(compareToValue) + " # " +
                        Util.getPrettyNumber(compareValue);

                ErrorsLog.log("\t\t" + column + ": " + error, "tallyErrors.log");
            }
        });
    }

    //**************************************************************************

    public final void setTiles() {

        this.tiles = new HashMap<String, String>() {};

        this.tileList.forEach((String type, ArrayList<String>typeTiles) -> {
            typeTiles.stream().forEach(tile -> {
                if (this.skipTiles.get(tile) == null) {
                   this.tiles.put(tile, type);
                }
            });
        });
    }

    //**************************************************************************

}