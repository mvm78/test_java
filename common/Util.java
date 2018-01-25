package test_java.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.nio.charset.StandardCharsets;

import test_java.tiles.Tile;

public class Util {

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static void debugOutput(HashMap<String, Object> data) {

        Tile tile = (Tile)data.get("tile");
        String finalCmd = (String)data.get("finalCmd");
        List<String []> lines = (List<String []>)((ArrayList<String []>)data.get("lines")).clone();
        String parentLine = (String)data.get("parentLine");
        boolean skipCompare = data.get("skipCompare") == null ? true :
                (boolean)data.get("skipCompare");

        if (tile.getDebug() == 0) {
            return;
        }

        String resetColor = Consts.RESET_COLOR;

        if (parentLine.isEmpty()) {
            System.out.println(resetColor); // empty line
            System.out.println(Consts.BRIGHT_MAGENTA + tile.getTitle() + ":" + resetColor);
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

        if (lines.isEmpty()) {
            System.out.println(Consts.RED + "\t" + "NO DATA");
        } else {
            lines.forEach(split -> {

                    String line = String.join(tile.getSplitChar(), split);

                    String lineColor = skipCompare ? Consts.DARK_GREY :
                            Util.getLineColor(line, parentLine);

                    System.out.println(resetColor + lineColor + "\t" + line + resetColor);
                });
        }

        System.out.println(resetColor);
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

        Map<String, Long> parsedTime = Util.getParsedTime(dateTime);

        Long unixTime = parsedTime.get("unixTime") / 1000;
        Long ms = parsedTime.get("ms");

        String milliseconds = ms == 0 ? "" : "." + String.valueOf(ms);

        return String.valueOf(unixTime) + milliseconds;
    }

    //**************************************************************************

    private static Map<String, Long> getParsedTime(String dateTime) {

        Long unixValue = 0L;

        String [] splitDateTime = dateTime.split("\\s+");

        String [] splitTime = splitDateTime[0].split("\\.");

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");

        try {

            Date parsedEndDate = dateFormat.parse(splitTime[0] + " " + splitDateTime[1]);

            unixValue = parsedEndDate.getTime();
        } catch (ParseException e) {
            System.err.println(Consts.BRIGHT_RED + "Invalid End Time");
        }

        Long ms = splitTime.length > 0 ? Long.valueOf(splitTime[1]) : 0;
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

        Map<String, Long> begin = Util.getParsedTime(beginTime);
        Map<String, Long> end = Util.getParsedTime(endTime);

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

    public static boolean getBufferLineFilter(String [] line) {

        for (String item : new String [] {"#I;", "window", "t=Refresh;"}) {
            if (item.equals(line[0])) {
                return false;
            }
        }

        return true;
    }

    //**************************************************************************

    public static String getBase64(String value) {

        byte[] authBytes = value.getBytes(StandardCharsets.UTF_8);

        return "BASE6464BASE" + Base64.getEncoder().encodeToString(authBytes);
    }

    //**************************************************************************

    public static String getFromTimestamp(String value) {

        String [] splitTime = value.split("\\.");

        Date date = new Date(Long.valueOf(splitTime[0]) * 1000L);
        SimpleDateFormat textFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        String dateTime = textFormat.format(date);

        dateTime += splitTime.length > 0 ? "." + splitTime[1].substring(0, 6) : "";

        String [] splitDateTime = dateTime.split("\\s+");

        return splitDateTime[1] + " " + splitDateTime[0];
    }

    //**************************************************************************

}
