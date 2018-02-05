package test_java;

import java.util.Arrays;
import test_java.common.Util;
import test_java.reports.*;

public class Test_java {

    public static void main(String[] args) {

        Util.removeLogs();
        Util.removeShellFiles();

        String [] reports = {
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

        Arrays.stream(reports).parallel()
                .forEach(report -> {
                    ReportFactory.getReport("test_java.reports." + report).tests();
                });

        ErrorsLog.outputLog();
        Util.removeShellFiles();

        System.exit(0);
    }

    //**************************************************************************

}