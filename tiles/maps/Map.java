package test_java.tiles.maps;

import test_java.tiles.Tile;

public abstract class Map extends Tile {

    //**************************************************************************

    public Map() {

        this.setTileType("map");
    }

    //**************************************************************************

    @Override
    public void setWindow(float window) {

        this.setWindow(this.getWindow() == null ? "0.0" : this.getWindow());
    }

    //**************************************************************************

}
