package test_java.tiles.maps;

import test_java.tiles.Tile;

public abstract class Map extends Tile {

    //**************************************************************************

    public Map() {

        this.tileType = "map";
    }

    //**************************************************************************

    @Override
    public void setWindow(float timeInterval) {

        this.window = this.window == null ? "0.0" : this.window;
    }

    //**************************************************************************

}
