package test_java.reports;

import java.util.*;

public class AnomalousTCPSessions extends Report {

    //**************************************************************************

    public AnomalousTCPSessions() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Anomalous TCP Sessions";
        this.tilesFolder = "AnomalousTCPSessions";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("UnacknowledgedTCPSessionsTrend");
                add("ServerResetNoBytesTCPSessionsTrend");
                add("ClientResetTCPSessionsTrend");
                add("ShortTCPSessionsTrend");
                add("LongTCPSessionsTrend");
                add("HighRetransmissionTCPSessionsTrend");
                add("PossibleNetworkIssueTCPSessionsTrend");
                add("PossibleServerOrApplicationIssueTCPSessionsTrend");
            }});
            put("tables", new ArrayList<String>() {{
                add("UnacknowledgedTCPSessions");
                add("ServerResetNoBytesTCPSessions");
                add("ClientResetTCPSessions");
                add("ShortTCPSessions");
                add("LongTCPSessions");
                add("HighRetransmissionTCPSessions");
                add("PossibleNetworkIssueTCPSessions");
                add("PossibleServerOrApplicationIssueTCPSessions");
            }});
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("UnacknowledgedTCPSessionsTrend", new String [] {
                "UnacknowledgedTCPSessions",
            });
            put("ServerResetNoBytesTCPSessionsTrend", new String [] {
                "ServerResetNoBytesTCPSessions",
            });
            put("ClientResetTCPSessionsTrend", new String [] {
                "ClientResetTCPSessions",
            });
            put("ShortTCPSessionsTrend", new String [] {
                "ShortTCPSessions",
            });
            put("LongTCPSessionsTrend", new String [] {
                "LongTCPSessions",
            });
            put("HighRetransmissionTCPSessionsTrend", new String [] {
                "HighRetransmissionTCPSessions",
            });
            put("PossibleNetworkIssueTCPSessionsTrend", new String [] {
                "PossibleNetworkIssueTCPSessions",
            });
            put("PossibleServerOrApplicationIssueTCPSessionsTrend", new String [] {
                "PossibleServerOrApplicationIssueTCPSessions",
            });
        }};
    };

    //**************************************************************************

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}