package test_java;

import java.util.Arrays;

import test_java.common.Util;
import test_java.reports.*;

public class Test_java {

    private static final String[] REPORTS = {
            "PerformanceOverview",
            "TopApplications",
            "TopApplicationPorts",
            "TopServers",
            "TopConversations",
            "NetworkPerformance",
            "Multicast",
            "DNSPerformance",
            "WebPerformance",
            "DatabasePerformance",
            "SIP_KPIs",
            "RTP_KPIs",
            "AnomalousTCPSessions",
            "SNMP",
            "FlowBasedRTP_KPIs",
            "Experts",
            "NetFlow",
    };

    //**************************************************************************

    private static String[] getReports() {

        return Test_java.REPORTS;
    }

    //**************************************************************************

    public static void main(final String[] args) {

        Util.removeLogs();
        Util.removeShellFiles();

        Arrays.stream(Test_java.getReports()).parallel()
                .forEach(report -> {
                    ReportFactory.getReport("test_java.reports." + report).tests();
                });

        ErrorsLog.outputLog();
        Util.removeShellFiles();

        System.exit(0);
    }

    //**************************************************************************

}