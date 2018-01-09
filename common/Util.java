package test_java.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

import test_java.tiles.Tile;

public class Util {

    //**************************************************************************

    public static void debugOutput(Tile tile, String finalCmd, String parentLine) {

        if (tile.getDebug() == 0) {
            return;
        }

        if (parentLine.isEmpty()) {
            System.out.println(Consts.RESET_COLOR); // empty line
            System.out.println(Consts.BRIGHT_MAGENTA + tile.getTitle() + ":" + Consts.RESET_COLOR);
            System.out.println(Consts.MAGENTA + finalCmd);
        } else {

            System.out.println(Consts.BLUE + finalCmd);

            if (tile.getDebug() > 1) {
                System.out.println(Consts.MAGENTA + "\t" + parentLine);
            }
        }

        if (tile.getDebug() < 2) {
            return;
        }

        String line;
        boolean isEmpty = true;

        BufferedReader results = tile.getQueryResults(finalCmd);

        try {
            while ((line = results.readLine()) != null) {

                line = line.trim();
                isEmpty = false;

                String lineColor = Util.getLineColor(line, parentLine);

                System.out.println(lineColor + "\t" + line + Consts.RESET_COLOR);
            }
        } catch (IOException e) {
            System.err.println(Consts.BRIGHT_RED + "Error reading query file");
            System.exit(1);
        }

        if (isEmpty) {
            System.out.println(Consts.RED + "\t" + "NO DATA");
        }

        System.out.println(Consts.RESET_COLOR);
    }

    //**************************************************************************

    private static String getLineColor(String line, String parentLine) {

        String color = parentLine.isEmpty() ? Consts.MAGENTA : Consts.BLUE;
        boolean isEqual = parentLine.equals(line);

        if (! isEqual) {

            int parentStart = Math.max(parentLine.indexOf(" "), 0);
            int lineStart = Math.max(line.indexOf(" "), 0);

            String parentEffectiveString = parentLine.substring(parentStart);
            String lineEffectiveString = line.substring(lineStart);

            isEqual = parentEffectiveString.equals(lineEffectiveString);
        }

        return isEqual ? Consts.DARK_GREEN : color;
    }

    //**************************************************************************

    public static String getPrettyNumber(double number) {

        long intPart = (long)number;
        String fracPart = String.valueOf(number - intPart);

        float decimals = Math.round(Float.valueOf(fracPart) * 1000F) / 1000F;

        String decPart = decimals == 0 ? "" :
                String.valueOf(decimals).substring(1);

        return String.format("%,d", intPart) + decPart;
    }

    //**************************************************************************

    public static String getTimeString(String dateTime) {

        HashMap<String, Long> parsedTime = Util.getParsedTime(dateTime);

        Long unixTime = parsedTime.get("unixTime") / 1000;
        Long ms = parsedTime.get("ms");

        String milliseconds = ms == 0 ? "" : "." + String.valueOf(ms);

        return String.valueOf(unixTime) + milliseconds;
    }

    //**************************************************************************

    protected static HashMap<String, Long> getParsedTime(String dateTime) {

        Long unixValue = 0L;
        String milliseconds = "";
        int spacePos = dateTime.indexOf(" ");

        String date = dateTime.substring(spacePos + 1);
        String time = dateTime.substring(0, spacePos);

        int dotPos = time.indexOf(".");

        if (dotPos > -1) {
            milliseconds = time.substring(dotPos + 1);
            time = time.substring(0, dotPos);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");

        try {

            Date parsedEndDate = dateFormat.parse(time + " " + date);

            unixValue = parsedEndDate.getTime();
        } catch (ParseException e) {
            System.err.println(Consts.BRIGHT_RED + "Invalid End Time");
        }

        Long ms = milliseconds.isEmpty() ? 0 : Long.valueOf(milliseconds);
        Long unixTime = unixValue;

        return new HashMap<String, Long>() {
            {
                put("unixTime", unixTime);
                put("ms", ms);
            }
        };
    }

    //**************************************************************************

    public static float getTimeInterval(String beginTime, String endTime) {

        HashMap<String, Long> begin = Util.getParsedTime(beginTime);
        HashMap<String, Long> end = Util.getParsedTime(endTime);

        Long beginUnixTime = begin.get("unixTime") + begin.get("ms");
        Long endUnixTime = end.get("unixTime") + end.get("ms");

        Long timeInterval = endUnixTime - beginUnixTime;

        return timeInterval.floatValue() / 1000;
    }

    //**************************************************************************

    public static String [] split(String line, String splitChar) {

        String splitExpr;

        switch (splitChar) {
            case ",": // split by comma
                splitExpr = ",";
                break;
            default: // split by space
                splitExpr = "\\s+";
                break;
        }
       // splitting the string on splitExpr that is followed by an even number of double quotes.
       // In other words, it splits on splitExpr outside the double quotes
       String pattern = splitExpr + "(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
//    splitExpr     - Split on splitExpr
//    (?=           - Followed by
//       (?:        - Start a non-capture group
//         [^"]*    - 0 or more non-quote characters
//         "        - 1 quote
//         [^"]*    - 0 or more non-quote characters
//         "        - 1 quote
//       )*         - 0 or more repetition of non-capture group (multiple of 2 quotes will be even)
//       [^"]*      - Finally 0 or more non-quotes
//       $          - Till the end  (This is necessary, else every comma will satisfy the condition)
//    )
        return line.split(pattern, -1);
    }

    //**************************************************************************

}
