package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class AnomalousTCPSessions extends Report {

    //**************************************************************************

    public AnomalousTCPSessions() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("Anomalous TCP Sessions");
        this.setTilesFolder("AnomalousTCPSessions");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("charts", new String[] {
                "UnacknowledgedTCPSessionsTrend",
                "ServerResetNoBytesTCPSessionsTrend",
                "ClientResetTCPSessionsTrend",
                "ShortTCPSessionsTrend",
                "LongTCPSessionsTrend",
                "HighRetransmissionTCPSessionsTrend",
                "PossibleNetworkIssueTCPSessionsTrend",
                "PossibleServerOrApplicationIssueTCPSessionsTrend",
            });
            put("tables", new String[] {
                "UnacknowledgedTCPSessions",
                "ServerResetNoBytesTCPSessions",
                "ClientResetTCPSessions",
                "ShortTCPSessions",
                "LongTCPSessions",
                "HighRetransmissionTCPSessions",
                "PossibleNetworkIssueTCPSessions",
                "PossibleServerOrApplicationIssueTCPSessions",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("UnacknowledgedTCPSessionsTrend", new String[] {
                "UnacknowledgedTCPSessions",
            });
            put("ServerResetNoBytesTCPSessionsTrend", new String[] {
                "ServerResetNoBytesTCPSessions",
            });
            put("ClientResetTCPSessionsTrend", new String[] {
                "ClientResetTCPSessions",
            });
            put("ShortTCPSessionsTrend", new String[] {
                "ShortTCPSessions",
            });
            put("LongTCPSessionsTrend", new String[] {
                "LongTCPSessions",
            });
            put("HighRetransmissionTCPSessionsTrend", new String[] {
                "HighRetransmissionTCPSessions",
            });
            put("PossibleNetworkIssueTCPSessionsTrend", new String[] {
                "PossibleNetworkIssueTCPSessions",
            });
            put("PossibleServerOrApplicationIssueTCPSessionsTrend", new String[] {
                "PossibleServerOrApplicationIssueTCPSessions",
            });
        }});
    };

    //**************************************************************************

}