package test_java.reports;

import java.util.*;

public class PerformanceOverview extends Report {

    //**************************************************************************

    public PerformanceOverview() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Performance Overview";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("BitRateAndPacketRate");
                add("ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes");
            }});
            put("tables", new ArrayList<String>() {{
//                add("Flows");        missing on 10.30.165.20
                add("TopApplicationsByBytesAndPackets");
                add("TopApplicationPortsByBytesAndPackets");
                add("TopSourcesByBytesAndPackets");
                add("IPConversations");
                add("TopApplicationsByResponseTimeAndRetransmittedBytes");
                add("TopApplicationPortsByResponseTimeAndRetransmittedBytes");
                add("TopServersByResponseTimeAndRetransmittedBytes");
                add("TopHostPairsByResponseTimeAndRetransmittedBytes");
                add("NetworkSessions");
                add("TCPConnections");
            }});
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

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}