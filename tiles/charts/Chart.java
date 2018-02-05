package test_java.tiles.charts;

import java.util.HashMap;
import java.util.LinkedHashMap;
import test_java.tiles.Tile;

public abstract class Chart extends Tile {

    private float minWindow = 1;

    //**************************************************************************

    public Chart() {

        this.setTileType("charts");
        this.debug = 2;
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

    protected final void setCommonByData() {

        this.setFields(new String [] {
            this.getCommonBy().getFields(),
        });
        this.filters = new String [] {};
        this.columns = this.getCommonBy().appendCompareColumns(
                new LinkedHashMap<String, HashMap<String, Object>>() {}, 1
        );
    }

    //**************************************************************************

}
