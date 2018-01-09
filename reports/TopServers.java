package test_java.reports;

import java.util.*;

public class TopServers extends Report {

    //**************************************************************************

    public TopServers() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Top Servers";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("BitRateAndPacketRate");
                add("ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes");
                add("ThroughputVsGoodput");
            }});
            put("tables", new ArrayList<String>() {{
                add("TopSourcesByBytesAndPackets");
                add("TopTCPServersByBytes");
                add("TopServersByResponseTimeAndRetransmittedBytes");
                add("TopServersByThroughput");
            }});
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