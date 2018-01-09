package test_java.tiles.tables;

import test_java.tiles.Tile;

public abstract class Table extends Tile {

    //**************************************************************************

    public Table() {

        this.tileType = "table";
    }

    //**************************************************************************

    @Override
    public void setWindow(float timeInterval) {

        this.window = this.window == null ? "0.0" : this.window;
    }

    //**************************************************************************

}
