package test_java.reports;

import test_java.common.Consts;

public abstract class ReportFactory {

    public static Report getReport(String className)
    {
        Report report = null;

        try {
            report = (Report)Class.forName(className).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.err.println(Consts.BRIGHT_RED + "Error creating " + className + " instance");
            System.exit(1);
        }

        if (report != null) {
            report.setTiles();
        }

        return report;
    }

    //**************************************************************************

}