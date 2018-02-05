package test_java.tiles.charts;

import java.util.HashMap;
import java.util.LinkedHashMap;
import test_java.tiles.Tile;

public abstract class Chart extends Tile {

    protected float minWindow = 1;

    //**************************************************************************

    public Chart() {

        this.setTileType("charts");
        this.debug = 2;
    }

    //**************************************************************************

    @Override
    public void setWindow(float timeInterval) {

        float tileWindow = timeInterval / 50;

        float rounded = Math.round(tileWindow * 1000F) / 1000F;

        float windowValue = Math.max(this.minWindow, Math.max(0.001F, rounded));

        this.window = String.valueOf(windowValue);
    }

    //**************************************************************************

    protected final void setCommonByData() {

        this.fields = new String [] {
            this.commonBy.getFields(),
        };
        this.filters = new String [] {};
        this.columns = this.commonBy.appendCompareColumns(
                new LinkedHashMap<String, HashMap<String, Object>>() {}, 1
        );
    }

    //**************************************************************************

}
