package test_java.reports;

import java.util.*;

public class TopServers extends Report {

    //**************************************************************************

    public TopServers() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("Top Servers");

        this.setTileList(new HashMap<String, String []>() {{
            put("charts", new String [] {
                "BitRateAndPacketRate",
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "ThroughputVsGoodput",
            });
            put("tables", new String [] {
                "TopSourcesByBytesAndPackets",
                "TopTCPServersByBytes",
                "TopServersByResponseTimeAndRetransmittedBytes",
                "TopServersByThroughput",
            });
        }});

        this.setTallyCheck(new HashMap<String, String []>() {{
            put("TopTCPServersByBytes", new String [] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "TopServersByResponseTimeAndRetransmittedBytes",
            });
            put("TopServersByThroughput", new String [] {
                "ThroughputVsGoodput",
            });
        }});
    }

    //**************************************************************************

}