package test_java.reports;

import java.util.*;

public class TopConversations extends Report {

    //**************************************************************************

    public TopConversations() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("Top Conversations");

        this.setTileList(new HashMap<String, String[]>() {{
            put("charts", new String[] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "ThroughputVsGoodput",
            });
            put("tables", new String[] {
                "IPConversations",
                "TopMACAddressPairsByBytesAndPackets",
                "TopTCPConversationsByBytes",
                "TCPConnections",
                "TopHostPairsByResponseTimeAndRetransmittedBytes",
                "TopHostPairsByThroughput",
                "TopCountryPairsByBytesAndPackets",
                "TopCountryPairsTCPPerformance",
            });
        }});

        this.setTallyCheck(new HashMap<String, String[]>() {{
            put("TopTCPConversationsByBytes", new String[] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "TopHostPairsByResponseTimeAndRetransmittedBytes",
                "TopCountryPairsByBytesAndPackets",
                "TopCountryPairsTCPPerformance",
            });
            put("TopHostPairsByThroughput", new String[] {
                "ThroughputVsGoodput",
            });
        }});
    }

    //**************************************************************************

}