package test_java.reports;

import test_java.common.Factory;

public class ReportFactory extends Factory {

    public static Report getReport(String className)
    {
        Report report = Factory.getInstance(className);

        if (report != null) {
            report.setTiles();
        }

        return report;
    }

    //**************************************************************************

}