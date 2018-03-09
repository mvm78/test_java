package test_java.common;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import test_java.ErrorsLog;

public class Util {

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static void debugOutput(final Map<String, Object> data) {

        final String finalCmd = (String)data.get("finalCmd");
        final AtomicReference<List<String[]>> lines =
                new AtomicReference<>((List)((ArrayList)data.get("lines")).clone());
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

        if (lines.get().isEmpty()) {
            System.out.println(Consts.getRed() + "\t" + "NO DATA");
        } else {
            lines.get().forEach(split -> {

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

        final AtomicReference<Double> number =
                new AtomicReference<>(Double.valueOf(stringValue));

        final AtomicLong intPart = new AtomicLong(Long.valueOf(stringValue));

        final String fracPart = String.valueOf(number.get() - intPart.get());

        final AtomicReference<Float> decimals = new AtomicReference<>(
                Math.round(Float.valueOf(fracPart) * 1000F) / 1000F
        );

        final String decPart = decimals.get() == 0 ? "" :
                String.valueOf(decimals.get()).substring(1);

        return String.format("%,d", intPart.get()) + decPart;
    }

    //**************************************************************************

    public static boolean isNumeric(final String value) {

        return value != null && value.matches("[-+]?\\d*\\.?\\d+");
    }

    //**************************************************************************

    public static String getTimeStamp(final String dateTime) {

        final AtomicReference<Map<String, Long>> parsedTime =
                new AtomicReference<>(Util.getParsedTime(dateTime));

        final AtomicLong unixTime =
                new AtomicLong(parsedTime.get().get("unixTime") / 1000);
        final AtomicLong ms = new AtomicLong(parsedTime.get().get("ms"));

        final String milliseconds = ms.get() == 0 ? "" :
                "." + String.valueOf(ms.get());

        return String.valueOf(unixTime.get()) + milliseconds;
    }

    //**************************************************************************

    private static Map<String, Long> getParsedTime(final String dateTime) {

        AtomicLong unixValue = new AtomicLong(0L);

        final AtomicReference<String[]> splitDateTime =
                new AtomicReference<>(dateTime.split("\\s+"));

        final AtomicReference<String[]> splitTime =
                new AtomicReference<>(splitDateTime.get()[0].split("\\."));

        final AtomicReference<SimpleDateFormat> dateFormat =
                new AtomicReference<>(new SimpleDateFormat("HH:mm:ss MM/dd/yyyy"));

        final String time = splitTime.get()[0];
        final String date = splitDateTime.get()[1];

        try {

            final AtomicReference<Date> parsedEndDate =
                    new AtomicReference<>(dateFormat.get().parse(time + " " + date));

            unixValue.set(parsedEndDate.get().getTime());
        } catch (ParseException e) {
            System.err.println(Consts.getBrightRed() + "Invalid End Time");
        }

        return new HashMap<String, Long>() {{
            put("unixTime", unixValue.get());
            put("ms", splitTime.get().length > 1 ? Long.valueOf(splitTime.get()[1]) : 0);
        }};
    }

    //**************************************************************************

    public static String getTimeInterval(final String beginTime, final String endTime) {

        final AtomicReference<Map<String, Long>> begin =
                new AtomicReference<>(Util.getParsedTime(beginTime));
        final AtomicReference<Map<String, Long>> end =
                new AtomicReference<>(Util.getParsedTime(endTime));

        final AtomicLong beginUnixTime =
                new AtomicLong(begin.get().get("unixTime") + begin.get().get("ms"));
        final AtomicLong endUnixTime =
                new AtomicLong(end.get().get("unixTime") + end.get().get("ms"));

        final AtomicLong timeInterval =
                new AtomicLong(endUnixTime.get() - beginUnixTime.get());

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
        final AtomicReference<String[]> split =
                new AtomicReference(line.split(pattern, -1));

        return shift > 0 ? Arrays.copyOfRange(split.get(), shift, split.get().length) :
                split.get();
    }

    //**************************************************************************

    public static boolean getBufferLineFilter(final String[] line) {

        return ! Stream.of("#I;", "window", "t=Refresh;").parallel()
                .anyMatch(item -> item.equals(line[0]));
    }

    //**************************************************************************

    public static String getBase64(final String value) {

        final AtomicReference<byte[]> authBytes =
                new AtomicReference<>(value.getBytes(StandardCharsets.UTF_8));

        return "BASE6464BASE" + Base64.getEncoder().encodeToString(authBytes.get());
    }

    //**************************************************************************

    public static String getFromTimestamp(final String value) {

        final AtomicReference<String[]> splitTime =
                new AtomicReference<>(value.split("\\."));

        final AtomicReference<Date> date = new AtomicReference<>(
                new Date(Long.valueOf(splitTime.get()[0]) * 1000L)
        );
        final AtomicReference<SimpleDateFormat> textFormat = new AtomicReference<>(
                new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
        );
        final String milliseconds = splitTime.get().length > 1 ?
                "." + splitTime.get()[1].substring(0, 6) : "";

        final String dateTime = textFormat.get().format(date) + milliseconds;

        final AtomicReference<String[]> splitDateTime =
                new AtomicReference<>(dateTime.split("\\s+"));

        return splitDateTime.get()[1] + " " + splitDateTime.get()[0];
    }

    //**************************************************************************

    public static void removeLogs() {

        Util.removeFiles(
                // array of File[]
                Arrays.stream(ErrorsLog.getLogFiles()).parallel()
                        .map(file -> new File(Consts.getFolder() + file))
                        .toArray(File[]::new)
        );
    }

    //**************************************************************************

    public static void removeShellFiles() {

        final AtomicReference<File> folder =
                new AtomicReference<>(new File(Consts.getFolder()));

        Util.removeFiles(
                // array of File[]
                folder.get().listFiles((final File dontneed, final String name) -> {
                    return name.startsWith("run_query");
                })
        );
    }

    //**************************************************************************

    private static void removeFiles(final File[] files) {

        Arrays.stream(files).parallel()
                .filter(file -> file.exists() && ! file.isDirectory())
                .filter(file -> ! file.delete())
                .forEach(file -> {
                    System.err.println("Can't remove " + file.getAbsolutePath());
                });
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static <T> T updateMap(T hashMap, String key, Object value) {

        ((Map)hashMap).put(key, value);

        return (T)hashMap;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static <T> T removeFromMap(T hashMap, String key) {

        ((Map)hashMap).remove(key);

        return (T)hashMap;
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static <T> T addToList(T list, Object value) {

        ((List)list).add(value);

        return (T)list;
    }

    //**************************************************************************

}