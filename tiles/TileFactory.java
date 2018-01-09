package test_java.tiles;

import test_java.common.Consts;

public abstract class TileFactory {

    public static Tile getTile(String className, float timeInterval)
    {
        Tile tile = null;

        try {
            tile = (Tile)Class.forName(className).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.err.println(Consts.BRIGHT_RED + "Error creating " + className + " instance");
            System.exit(1);
        }

        if (tile != null) {
            tile.setWindow(timeInterval);
        }

        return tile;
    }

    //**************************************************************************

}