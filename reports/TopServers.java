package test_java.reports;

import java.util.*;

public class TopServers extends Report {

    //**************************************************************************

    public TopServers() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Top Servers";

        this.tileList = new HashMap<String, String []>() {{
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
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopTCPServersByBytes", new String [] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "TopServersByResponseTimeAndRetransmittedBytes",
            });
            put("TopServersByThroughput", new String [] {
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