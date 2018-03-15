package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class NetFlow extends Report {

    //**************************************************************************

    public NetFlow() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("NetFlow");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("tables", new String[] {
                "NetFlow.NetFlowDevicesByBytesAndPackets",
                "NetFlow.NetFlowInputInterfacesByBytesAndPackets",
                "NetFlow.NetFlowOutputInterfacesByBytesAndPackets",
                "NetFlow.NetFlowInterfacePairsByBytesAndPackets",
                "IPConversations",
                "NetFlow.NetFlowTopProtocolAndEtherTypesByBytesAndPackets",
                "TopSourcesByBytesAndPackets",
                "TopApplicationPortsByBytesAndPackets",
                "TopCountryPairsByBytesAndPackets",
                "NetFlow.NetFlowSummaryByBytesAndPackets",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("NetFlowDevicesByBytesAndPackets", new String[] {
                "NetFlowInputInterfacesByBytesAndPackets",
                "NetFlowOutputInterfacesByBytesAndPackets",
                "NetFlowInterfacePairsByBytesAndPackets",
                "IPConversations",
                "NetFlowTopProtocolAndEtherTypesByBytesAndPackets",
                "TopSourcesByBytesAndPackets",
                "TopCountryPairsByBytesAndPackets",
                "NetFlowSummaryByBytesAndPackets",
            });
        }});
    };

    //**************************************************************************

}