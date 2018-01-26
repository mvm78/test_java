package test_java.tiles;

import test_java.common.Factory;

public class TileFactory extends Factory {

    public static Tile getTile(String className, float timeInterval)
    {
        Tile tile = Factory.getInstance(className);

        if (tile != null) {
            tile.setWindow(timeInterval);
        }

        return tile;
    }

    //**************************************************************************

}