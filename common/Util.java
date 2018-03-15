package test_java.common;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CopyOnWriteArrayList;

import test_java.ErrorsLog;

public class Util {

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static void debugOutput(final Map<String, Object> data) {

        final String finalCmd = (String)data.get("finalCmd");
        final List<String[]> lines = (List)((CopyOnWriteArrayList)data.get("lines")).clone();
        final String parentLine = (String)data.get("parentLine");
        final boolean skipCompare = data.get("skipCompare") == null ? true :
                (boolean)data.get("skipCompare");
        final byte gebug = (byte)data.get("gebug");
        final String title = (String)data.get("title");
        final String splitChar = (String)data.get("splitChar");

        if (gebug == 0) {
            return;
        }

        final String resetColor = Consts.getResetColor();

        if (parentLine.isEmpty()) {
            System.out.println(resetColor); // empty line
            System.out.println(Consts.getBrightMagenta() + title+ ":" + resetColor);
            System.out.println(Consts.getMagenta() + finalCmd);
        } else {

            System.out.println(Consts.getBlue() + finalCmd);

            if (gebug > 1) {
                System.out.println(Consts.getMagenta() + "\t" + parentLine);
            }
        }

        if (gebug < 2) {
            return;
        }

        if (lines.isEmpty()) {
            System.out.println(Consts.getRed() + "\t" + "NO DATA");
        } else {
            lines.forEach(split -> {

                    final String line = String.join(splitChar, split);

                    final String lineColor = skipCompare ? Consts.getDarkGrey() :
                            Util.getLineColor(line, parentLine);

                    System.out.println(resetColor + lineColor + "\t" + line + resetColor);
                });
        }

        System.out.println(resetColor);
    }

    //**************************************************************************

    private static String getLineColor(final String line, final String parentLine) {

        final String color = parentLine.isEmpty() ? Consts.getMagenta() :
                Consts.getBlue();
        boolean isEqual = parentLine.equals(line);

        if (! isEqual) {

            final int parentStart = Math.max(parentLine.indexOf(" "), 0);
            final int lineStart = Math.max(line.indexOf(" "), 0);

            final String parentEffectiveString = parentLine.substring(parentStart);
            final String lineEffectiveString = line.substring(lineStart);

            isEqual = parentEffectiveString.equals(lineEffectiveString);
        }

        return isEqual ? Consts.getDarkGreen() : color;
    }

    //**************************************************************************

    public static <T> String getPrettyNumber(final T value) {

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

    public static boolean isNumeric(final String value) {

        return value != null && value.matches("[-+]?\\d*\\.?\\d+");
    }

    //**************************************************************************

    public static String getTimeStamp(final String dateTime) {

        final Map<String, Long> parsedTime = Util.getParsedTime(dateTime);

        final Long unixTime = parsedTime.get("unixTime") / 1000;
        final Long ms = parsedTime.get("ms");

        final String milliseconds = ms == 0 ? "" : "." + String.valueOf(ms);

        return String.valueOf(unixTime) + milliseconds;
    }

    //**************************************************************************

    private static Map<String, Long> getParsedTime(final String dateTime) {

        Long unixValue = 0L;

        final String[] splitDateTime = dateTime.split("\\s+");

        final String[] splitTime = splitDateTime[0].split("\\.");

        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");

        try {

            final Date parsedEndDate = dateFormat.parse(splitTime[0] + " " + splitDateTime[1]);

            unixValue = parsedEndDate.getTime();
        } catch (ParseException e) {
            System.err.println(Consts.getBrightRed() + "Invalid End Time");
        }

        final Long ms = splitTime.length > 1 ? Long.valueOf(splitTime[1]) : 0;
        final Long unixTime = unixValue;

        return new HashMap<String, Long>() {{
            put("unixTime", unixTime);
            put("ms", ms);
        }};
    }

    //**************************************************************************

    public static String getTimeInterval(final String beginTime, final String endTime) {

        final Map<String, Long> begin = Util.getParsedTime(beginTime);
        final Map<String, Long> end = Util.getParsedTime(endTime);

        final Long beginUnixTime = begin.get("unixTime") + begin.get("ms");
        final Long endUnixTime = end.get("unixTime") + end.get("ms");

        final Long timeInterval = endUnixTime - beginUnixTime;

        return String.valueOf(timeInterval.floatValue() / 1000);
    }

    //**************************************************************************

    public static String[] split(final String line, final String splitChar) {
        // shift = 0 - will not require removal of the 1-st array element
        return Util.split(line, splitChar, 0);
    }

    //**************************************************************************

    public static String[] split(final String line, final String splitChar, final int shift) {

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
        final String[] split = line.split(pattern, -1);

        return shift > 0 ? Arrays.copyOfRange(split, shift, split.length) : split;
    }

    //**************************************************************************

    public static boolean getBufferLineFilter(final String[] line) {

        final String[] ignore = new String[] {"#I;", "window", "t=Refresh;"};

        return ! Arrays.stream(ignore) // .parallel()
                .anyMatch(item -> item.equals(line[0]));
    }

    //**************************************************************************

    public static String getBase64(final String value) {

        final byte[] authBytes = value.getBytes(StandardCharsets.UTF_8);

        return "BASE6464BASE" + Base64.getEncoder().encodeToString(authBytes);
    }

    //**************************************************************************

    public static String getFromTimestamp(final String value) {

        final String[] splitTime = value.split("\\.");

        final Date date = new Date(Long.valueOf(splitTime[0]) * 1000L);
        final SimpleDateFormat textFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        final String milliseconds = splitTime.length > 1 ?
                "." + splitTime[1].substring(0, 6) : "";

        final String dateTime = textFormat.format(date) + milliseconds;

        final String[] splitDateTime = dateTime.split("\\s+");

        return splitDateTime[1] + " " + splitDateTime[0];
    }

    //**************************************************************************

    public static void removeLogs() {

        final File[] files = Arrays.stream(ErrorsLog.getLogFiles()) // .parallel()
                .map(file -> new File(Consts.getFolder() + file))
                .toArray(File[]::new);

        Util.removeFiles(files);
    }

    //**************************************************************************

    public static void removeShellFiles() {

        final File folder = new File(Consts.getFolder());

        final File[] files = folder.listFiles((final File dontneed, final String name) -> {
            return name.startsWith("run_query");
        });

        Util.removeFiles(files);
    }

    //**************************************************************************

    private static void removeFiles(final File[] files) {

        Arrays.stream(files) // .parallel()
                .filter(file -> file.exists() && ! file.isDirectory())
                .filter(file -> ! file.delete())
                .forEach(file -> {
                    System.err.println("Can't remove " + file.getAbsolutePath());
                });
    }

    //**************************************************************************

}