package test_java.tiles.charts;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.Tile;
import test_java.tiles.common.CommonBy;

public abstract class Chart extends Tile {

    private float minWindow = 1;

    //**************************************************************************

    public Chart() {

        this.setTileType("charts");
    }

    //**************************************************************************

    final public float getMinWindow() {

        return this.minWindow;
    }

    //**************************************************************************

    final public void setMinWindow(float minWindow) {

        this.minWindow = minWindow;
    }

    //**************************************************************************

    @Override
    public void setWindow(float timeInterval) {

        float tileWindow = timeInterval / 50;

        float rounded = Math.round(tileWindow * 1000F) / 1000F;

        float windowValue = Math.max(this.getMinWindow(), Math.max(0.001F, rounded));

        this.setWindow(String.valueOf(windowValue));
    }

    //**************************************************************************

    protected final <T extends CommonBy> void setCommonByData(T commonBy) {

        this.setCommonBy(commonBy);

        final LinkedHashMap<String, HashMap<String, Object>> instanceFilterColumns =
                new LinkedHashMap<String, HashMap<String, Object>>() {};
        final LinkedHashMap<String, HashMap<String, Object>> instanceColumns =
                commonBy.appendCompareColumns(instanceFilterColumns, this.getColumnIncrement());

        this.setFields(new String [] {
            commonBy.getFields(),
        });
        this.setFilters();
        this.setColumns(instanceColumns);
    }

    //**************************************************************************

}