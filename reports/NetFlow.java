package test_java.reports;

import java.util.*;

public class NetFlow extends Report {

    //**************************************************************************

    public NetFlow() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "NetFlow";

        this.tileList = new HashMap<String, String []>() {{
            put("tables", new String [] {
//                "NetFlow.NetFlowDevicesByBytesAndPackets",
//                "NetFlow.NetFlowInputInterfacesByBytesAndPackets",
//                "NetFlow.NetFlowOutputInterfacesByBytesAndPackets",
//                "NetFlow.NetFlowInterfacePairsByBytesAndPackets",
//                "IPConversations",
                "NetFlow.NetFlowTopProtocolAndEtherTypesByBytesAndPackets",
                "TopSourcesByBytesAndPackets",
                "TopApplicationPortsByBytesAndPackets",
                "TopCountryPairsByBytesAndPackets",
//                "NetFlow.NetFlowSummaryByBytesAndPackets",
            });
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("NetFlowDevicesByBytesAndPackets", new String [] {
                "NetFlowInputInterfacesByBytesAndPackets",
                "NetFlowOutputInterfacesByBytesAndPackets",
                "NetFlowInterfacePairsByBytesAndPackets",
                "IPConversations",
                "NetFlowTopProtocolAndEtherTypesByBytesAndPackets",
                "TopSourcesByBytesAndPackets",
                "TopCountryPairsByBytesAndPackets",
                "NetFlowSummaryByBytesAndPackets",
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