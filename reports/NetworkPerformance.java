package test_java.reports;

import java.util.*;

public class NetworkPerformance extends Report {

    //**************************************************************************

    public NetworkPerformance() {

        this.setAppPath("/usr/local/mercury/bin/agg");

        this.setTitle("Network Performance");

        this.setTileList(new HashMap<String, String []>() {{
            put("charts", new String [] {
                "BitRateAndPacketRate",
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes",
                "ThroughputVsGoodput",
            });
            put("maps", new String [] {
                "ConnectionsNetworkTimeResponseTimeAndRetransmittedBytesMap",
            });
            put("tables", new String [] {
                "TopProtocolsByBytesAndPackets",
                "TopLinkProtocolsByBytesAndPackets",
                "TopTCPLinkProtocolsByBytes",
                "TopTOSByBytesAndPackets",
                "TopVLAN",
                "TopVLANByBytesAndPackets",
            });
        }});

        this.setTallyCheck(new HashMap<String, String []>() {{
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
        }});
    };

    //**************************************************************************

}