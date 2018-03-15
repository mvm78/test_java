package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class TopServers extends Report {

    //**************************************************************************

    public TopServers() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("Top Servers");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("charts", new String[] {
                "BitRateAndPacketRate",
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "ThroughputVsGoodput",
            });
            put("tables", new String[] {
                "TopSourcesByBytesAndPackets",
                "TopTCPServersByBytes",
                "TopServersByResponseTimeAndRetransmittedBytes",
                "TopServersByThroughput",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("TopTCPServersByBytes", new String[] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "TopServersByResponseTimeAndRetransmittedBytes",
            });
            put("TopServersByThroughput", new String[] {
                "ThroughputVsGoodput",
            });
        }});
    }

    //**************************************************************************

}