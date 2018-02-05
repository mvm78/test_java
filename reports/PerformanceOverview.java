package test_java.reports;

import java.util.*;

public class PerformanceOverview extends Report {

    //**************************************************************************

    public PerformanceOverview() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.refresh = "refreshTO 5.0";

        this.setTitle("Performance Overview");

        this.tileList = new HashMap<String, String []>() {{
            put("charts", new String [] {
                "BitRateAndPacketRate",
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
            });
            put("tables", new String [] {
//                "Flows",        missing on 10.30.165.20
                "TopApplicationsByBytesAndPackets",
                "TopApplicationPortsByBytesAndPackets",
                "TopSourcesByBytesAndPackets",
                "IPConversations",
                "TopApplicationsByResponseTimeAndRetransmittedBytes",
                "TopApplicationPortsByResponseTimeAndRetransmittedBytes",
                "TopServersByResponseTimeAndRetransmittedBytes",
                "TopHostPairsByResponseTimeAndRetransmittedBytes",
                "NetworkSessions",
                "TCPConnections",
            });
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopApplicationPortsByBytesAndPackets", new String [] {
                "BitRateAndPacketRate",
                "TopSourcesByBytesAndPackets",
                "IPConversations"
            });
            put("TopApplicationPortsByResponseTimeAndRetransmittedBytes", new String [] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "TopHostPairsByResponseTimeAndRetransmittedBytes",
            });
        }};
    };

    //**************************************************************************

}