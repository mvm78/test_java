package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class TopApplicationPorts extends Report {

    //**************************************************************************

    public TopApplicationPorts() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("Top Application Ports");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("charts", new String[] {
                "BitRateAndPacketRate",
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "ThroughputVsGoodput",
            });
            put("tables", new String[] {
                "TopApplicationPortsByBytesAndPackets",
                "TopTCPApplicationPortsByBytes",
                "TopApplicationPortsByResponseTimeAndRetransmittedBytes",
                "TopApplicationPortsByThroughput",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("TopApplicationPortsByBytesAndPackets", new String[] {
                "BitRateAndPacketRate",
            });
            put("TopTCPApplicationPortsByBytes", new String[] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "TopApplicationPortsByResponseTimeAndRetransmittedBytes",
            });
            put("TopApplicationPortsByThroughput", new String[] {
                "ThroughputVsGoodput",
            });
        }});
    }

    //**************************************************************************

}