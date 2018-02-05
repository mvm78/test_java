package test_java.reports;

import java.util.*;

public class TopApplicationPorts extends Report {

    //**************************************************************************

    public TopApplicationPorts() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Top Application Ports";

        this.tileList = new HashMap<String, String []>() {{
            put("charts", new String [] {
                "BitRateAndPacketRate",
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "ThroughputVsGoodput",
            });
            put("tables", new String [] {
                "TopApplicationPortsByBytesAndPackets",
                "TopTCPApplicationPortsByBytes",
                "TopApplicationPortsByResponseTimeAndRetransmittedBytes",
                "TopApplicationPortsByThroughput",
            });
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopApplicationPortsByBytesAndPackets", new String [] {
                "BitRateAndPacketRate",
            });
            put("TopTCPApplicationPortsByBytes", new String [] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "TopApplicationPortsByResponseTimeAndRetransmittedBytes",
            });
            put("TopApplicationPortsByThroughput", new String [] {
                "ThroughputVsGoodput",
            });
        }};
    }

    //**************************************************************************

}