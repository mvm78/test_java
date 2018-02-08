package test_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import test_java.common.Consts;

public class ErrorsLog {

    public static final String[] LOG_FILES = {
        "errors.log",
        "tallyErrors.log"
    };

    //**************************************************************************

    public static void log(String text) {

        ErrorsLog.log(text, "errors.log");
    }

    //**************************************************************************

    public static void log(String text, String logFile) {

        if (text.isEmpty()) {
            return;
        }

        try (
                FileWriter fileWriter = new FileWriter(logFile, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter errorsLog = new PrintWriter(bufferedWriter)
        ) {

            errorsLog.println(text);
        } catch (IOException e) {

        }
    }

    //**************************************************************************

    public static void outputLog() {

        String line;

        System.out.println(Consts.RESET_COLOR);

        for (byte count=0; count<ErrorsLog.LOG_FILES.length; count++) {

            String fileName = ErrorsLog.LOG_FILES[count];

            File file = new File(fileName);

            if (file.exists() && ! file.isDirectory()) {
                try {

                    FileReader fileReader = new FileReader(fileName);

                    System.out.println(fileName + ":");

                    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                        while((line = bufferedReader.readLine()) != null) {
                            System.out.println(Consts.RED + line);
                        }

                        System.out.println(Consts.RESET_COLOR);

                        bufferedReader.close();
                    } catch (IOException e) {
                        System.err.println(Consts.BRIGHT_RED + "Error reading " + fileName);
                        System.exit(1);
                    }
                } catch (FileNotFoundException e) {
                    System.err.println(Consts.BRIGHT_RED + "Error reading " + fileName);
                    System.exit(1);
                }
            } else {
                System.out.println(fileName + ":");
                System.out.println(Consts.DARK_GREEN + "No error was found");
                System.out.println(Consts.RESET_COLOR);
            }
        }
    }

    //**************************************************************************

}
