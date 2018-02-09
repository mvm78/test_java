package test_java.common;

public final class Consts {

    private static final String FOLDER = "/home/vcr/test_java/";

    private static final String RED = (char)27 + "[31m";
    private static final String BRIGHT_RED = (char)27 + "[31;1m";
    private static final String DARK_RED = (char)27 + "[31;1;2m";
    private static final String BLUE = (char)27 + "[34m";
    private static final String BRIGHT_MAGENTA = (char)27 + "[35;1m";
    private static final String MAGENTA = (char)27 + "[35m";
    private static final String DARK_GREEN = (char)27 + "[32;1;2m";
    private static final String DARK_GREY = (char)27 + "[40;1m";
    private static final String RESET_COLOR = (char)27 + "[0m";

    //**************************************************************************

    public static String getFolder() {

        return Consts.FOLDER;
    }

    //**************************************************************************

    public static String getRed() {

        return Consts.RED;
    }

    //**************************************************************************

    public static String getBrightRed() {

        return Consts.BRIGHT_RED;
    }

    //**************************************************************************

    public static String getDarkRed() {

        return Consts.DARK_RED;
    }

    //**************************************************************************

    public static String getBlue() {

        return Consts.BLUE;
    }

    //**************************************************************************

    public static String getBrightMagenta() {

        return Consts.BRIGHT_MAGENTA;
    }

    //**************************************************************************

    public static String getMagenta() {

        return Consts.MAGENTA;
    }

    //**************************************************************************

    public static String getDarkGreen() {

        return Consts.DARK_GREEN;
    }

    //**************************************************************************

    public static String getDarkGrey() {

        return Consts.DARK_GREY;
    }

    //**************************************************************************

    public static String getResetColor() {

        return Consts.RESET_COLOR;
    }

    //**************************************************************************

}