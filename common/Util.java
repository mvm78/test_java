package test_java.common;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;

import test_java.ErrorsLog;

public class Util {

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static void debugOutput(Map<String, Object> data) {

        final String finalCmd = (String)data.get("finalCmd");
        final List<String []> lines =
                (List<String []>)((ArrayList<String []>)data.get("lines")).clone();
        final String parentLine = (String)data.get("parentLine");
        final boolean skipCompare = data.get("skipCompare") == null ? true :
                (boolean)data.get("skipCompare");
        final byte gebug = (byte)data.get("gebug");
        final String title = (String)data.get("title");
        final String splitChar = (String)data.get("splitChar");

        if (gebug == 0) {
            return;
        }

        final String resetColor = Consts.RESET_COLOR;

        if (parentLine.isEmpty()) {
            System.out.println(resetColor); // empty line
            System.out.println(Consts.BRIGHT_MAGENTA + title+ ":" + resetColor);
            System.out.println(Consts.MAGENTA + finalCmd);
        } else {

            System.out.println(Consts.BLUE + finalCmd);

            if (gebug > 1) {
                System.out.println(Consts.MAGENTA + "\t" + parentLine);
            }
        }

        if (gebug < 2) {
            return;
        }

        if (lines.isEmpty()) {
            System.out.println(Consts.RED + "\t" + "NO DATA");
        } else {
            lines.forEach(split -> {

                    final String line = String.join(splitChar, split);

                    final String lineColor = skipCompare ? Consts.DARK_GREY :
                            Util.getLineColor(line, parentLine);

                    System.out.println(resetColor + lineColor + "\t" + line + resetColor);
                });
        }

        System.out.println(resetColor);
    }

    //**************************************************************************

    private static String getLineColor(String line, String parentLine) {

        final String color = parentLine.isEmpty() ? Consts.MAGENTA : Consts.BLUE;
        boolean isEqual = parentLine.equals(line);

        if (! isEqual) {

            final int parentStart = Math.max(parentLine.indexOf(" "), 0);
            final int lineStart = Math.max(line.indexOf(" "), 0);

            final String parentEffectiveString = parentLine.substring(parentStart);
            final String lineEffectiveString = line.substring(lineStart);

            isEqual = parentEffectiveString.equals(lineEffectiveString);
        }

        return isEqual ? Consts.DARK_GREEN : color;
    }

    //**************************************************************************

    public static <T> String getPrettyNumber(T value) {

        final String stringValue = String.valueOf(value);

        if (! Util.isNumeric(stringValue)) {
            return "0";
        }

        final double number = Double.valueOf(stringValue);

        final long intPart = (long)number;

        final String fracPart = String.valueOf(number - intPart);

        final float decimals = Math.round(Float.valueOf(fracPart) * 1000F) / 1000F;

        final String decPart = decimals == 0 ? "" :
                String.valueOf(decimals).substring(1);

        return String.format("%,d", intPart) + decPart;
    }

    //**************************************************************************

    public static boolean isNumeric(String value) {

        return value != null && value.matches("[-+]?\\d*\\.?\\d+");
    }

    //**************************************************************************

    public static String getTimeStamp(String dateTime) {

        final Map<String, Long> parsedTime = Util.getParsedTime(dateTime);

        final Long unixTime = parsedTime.get("unixTime") / 1000;
        final Long ms = parsedTime.get("ms");

        final String milliseconds = ms == 0 ? "" : "." + String.valueOf(ms);

        return String.valueOf(unixTime) + milliseconds;
    }

    //**************************************************************************

    private static Map<String, Long> getParsedTime(String dateTime) {

        Long unixValue = 0L;

        final String [] splitDateTime = dateTime.split("\\s+");

        final String [] splitTime = splitDateTime[0].split("\\.");

        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");

        try {

            final Date parsedEndDate = dateFormat.parse(splitTime[0] + " " + splitDateTime[1]);

            unixValue = parsedEndDate.getTime();
        } catch (ParseException e) {
            System.err.println(Consts.BRIGHT_RED + "Invalid End Time");
        }

        final Long ms = splitTime.length > 1 ? Long.valueOf(splitTime[1]) : 0;
        final Long unixTime = unixValue;

        return new HashMap<String, Long>() {{
            put("unixTime", unixTime);
            put("ms", ms);
        }};
    }

    //**************************************************************************

    public static String getTimeInterval(String beginTime, String endTime) {

        final Map<String, Long> begin = Util.getParsedTime(beginTime);
        final Map<String, Long> end = Util.getParsedTime(endTime);

        final Long beginUnixTime = begin.get("unixTime") + begin.get("ms");
        final Long endUnixTime = end.get("unixTime") + end.get("ms");

        final Long timeInterval = endUnixTime - beginUnixTime;

        return String.valueOf(timeInterval.floatValue() / 1000);
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
       final String pattern = splitExpr + "(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
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

        final String [] ignore = new String [] {"#I;", "window", "t=Refresh;"};

        return ! Arrays.stream(ignore).parallel()
                .anyMatch(item -> item.equals(line[0]));
    }

    //**************************************************************************

    public static String getBase64(String value) {

        final byte[] authBytes = value.getBytes(StandardCharsets.UTF_8);

        return "BASE6464BASE" + Base64.getEncoder().encodeToString(authBytes);
    }

    //**************************************************************************

    public static String getFromTimestamp(String value) {

        final String [] splitTime = value.split("\\.");

        final Date date = new Date(Long.valueOf(splitTime[0]) * 1000L);
        final SimpleDateFormat textFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        String dateTime = textFormat.format(date);

        dateTime += splitTime.length > 1 ? "." + splitTime[1].substring(0, 6) : "";

        final String [] splitDateTime = dateTime.split("\\s+");

        return splitDateTime[1] + " " + splitDateTime[0];
    }

    //**************************************************************************

    public static void removeLogs() {

        for (byte count=0; count<ErrorsLog.LOG_FILES.length; count++) {

            final File logFile = new File(ErrorsLog.LOG_FILES[count]);

            if (logFile.exists()) {
                logFile.delete();
            }
        }
    }

    //**************************************************************************

    public static void removeShellFiles() {

        final File folder = new File("/home/vcr/test_java/");

        final File[] files = folder.listFiles((final File dontneed, final String name) -> {
            return name.startsWith("run_query");
        });

        Arrays.stream(files).parallel()
                .filter(file -> ! file.delete())
                .forEach(file -> {
                    System.err.println("Can't remove " + file.getAbsolutePath());
                });
    }

    //**************************************************************************

}