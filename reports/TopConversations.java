package test_java.reports;

import java.util.*;

public class TopConversations extends Report {

    //**************************************************************************

    public TopConversations() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Top Conversations";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes");
                add("ThroughputVsGoodput");
            }});
            put("tables", new ArrayList<String>() {{
                add("IPConversations");
                add("TopMACAddressPairsByBytesAndPackets");
                add("TopTCPConversationsByBytes");
                add("TCPConnections");
                add("TopHostPairsByResponseTimeAndRetransmittedBytes");
                add("TopHostPairsByThroughput");
                add("TopCountryPairsByBytesAndPackets");
                add("TopCountryPairsTCPPerformance");
            }});
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopTCPConversationsByBytes", new String [] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "TopHostPairsByResponseTimeAndRetransmittedBytes",
                "TopCountryPairsByBytesAndPackets",
                "TopCountryPairsTCPPerformance",
            });
            put("TopHostPairsByThroughput", new String [] {
                "ThroughputVsGoodput",
            });
        }};
    }

    //**************************************************************************

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}