package test_java.reports;

import java.util.*;

public class TopApplicationPorts extends Report {

    //**************************************************************************

    public TopApplicationPorts() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Top Application Ports";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("BitRateAndPacketRate");
                add("ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes");
                add("ThroughputVsGoodput");
            }});
            put("tables", new ArrayList<String>() {{
                add("TopApplicationPortsByBytesAndPackets");
                add("TopTCPApplicationPortsByBytes");
                add("TopApplicationPortsByResponseTimeAndRetransmittedBytes");
                add("TopApplicationPortsByThroughput");
            }});
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

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}