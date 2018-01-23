package test_java;

import test_java.reports.*;

public class Test_java {

    public static void main(String[] args) {

        ErrorsLog.removeLogs();

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
            "MediaFlow",
            "Experts",
        };

        for (String report : reports) {
            ReportFactory.getReport("test_java.reports." + report).tests();
        }

        ErrorsLog.outputLog();
    }

    //**************************************************************************

}