package test_java.tiles.charts;

import test_java.tiles.Tile;

public abstract class Chart extends Tile {

    protected float minWindow;

    //**************************************************************************

    public Chart() {

        this.tileType = "charts";
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

}
