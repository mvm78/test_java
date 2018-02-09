package test_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import test_java.common.Consts;

public class ErrorsLog {

    private static final String[] LOG_FILES = {
        "errors.log",
        "tallyErrors.log"
    };

    //**************************************************************************

    public static String[] getLogFiles() {

        return ErrorsLog.LOG_FILES;
    }

    //**************************************************************************

    public static void log(final String text) {

        ErrorsLog.log(text, "errors.log");
    }

    //**************************************************************************

    public static void log(final String text, final String logFile) {

        if (text.isEmpty()) {
            return;
        }

        try (
                final FileWriter fileWriter = new FileWriter(logFile, true);
                final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                final PrintWriter errorsLog = new PrintWriter(bufferedWriter)
        ) {

            errorsLog.println(text);
        } catch (IOException e) {

        }
    }

    //**************************************************************************

    public static void outputLog() {

        System.out.println(Consts.getResetColor());

        Arrays.stream(ErrorsLog.getLogFiles())
                .forEach(fileName -> {

                    final File file = new File(fileName);

                    if (file.exists() && ! file.isDirectory()) {
                        try {

                            String line;
                            final FileReader fileReader = new FileReader(fileName);

                            System.out.println(fileName + ":");

                            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                                while((line = bufferedReader.readLine()) != null) {
                                    System.out.println(Consts.getRed() + line);
                                }

                                System.out.println(Consts.getResetColor());

                                bufferedReader.close();
                            } catch (IOException e) {
                                System.err.println(Consts.getBrightRed() +
                                        "Error reading " + fileName);
                                System.exit(1);
                            }
                        } catch (FileNotFoundException e) {
                            System.err.println(Consts.getBrightRed() +
                                    "Error reading " + fileName);
                            System.exit(1);
                        }
                    } else {
                        System.out.println(fileName + ":");
                        System.out.println(Consts.getDarkGreen() + "No error was found");
                        System.out.println(Consts.getResetColor());
                    }
                });
    }

    //**************************************************************************

}