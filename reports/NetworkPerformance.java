package test_java.reports;

import java.util.*;

public class NetworkPerformance extends Report {

    //**************************************************************************

    public NetworkPerformance() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Network Performance";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("BitRateAndPacketRate");
                add("ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes");
                add("ThroughputVsGoodput");
            }});
            put("maps", new ArrayList<String>() {{
                add("ConnectionsNetworkTimeResponseTimeAndRetransmittedBytesMap");
            }});
            put("tables", new ArrayList<String>() {{
                add("TopProtocolsByBytesAndPackets");
                add("TopLinkProtocolsByBytesAndPackets");
                add("TopTCPLinkProtocolsByBytes");
                add("TopTOSByBytesAndPackets");
                add("TopVLAN");
                add("TopVLANByBytesAndPackets");
            }});
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopProtocolsByBytesAndPackets", new String [] {
                "BitRateAndPacketRate",
                "TopLinkProtocolsByBytesAndPackets",
                "TopTOSByBytesAndPackets",
                "TopVLANByBytesAndPackets",
            });
            put("TopTCPLinkProtocolsByBytes", new String [] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytesMap",
                "ThroughputVsGoodput",
                "TopVLAN",
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