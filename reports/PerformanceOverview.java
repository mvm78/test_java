package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class PerformanceOverview extends Report {

    //**************************************************************************

    public PerformanceOverview() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("Performance Overview");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("charts", new String[] {
                "BitRateAndPacketRate",
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
            });
            put("tables", new String[] {
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
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("TopApplicationPortsByBytesAndPackets", new String[] {
                "BitRateAndPacketRate",
                "TopSourcesByBytesAndPackets",
                "IPConversations"
            });
            put("TopApplicationPortsByResponseTimeAndRetransmittedBytes", new String[] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "TopHostPairsByResponseTimeAndRetransmittedBytes",
            });
        }});
    };

    //**************************************************************************

}