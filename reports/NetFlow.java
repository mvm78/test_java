package test_java.reports;

import java.util.*;

public class NetFlow extends Report {

    //**************************************************************************

    public NetFlow() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "NetFlow";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("tables", new ArrayList<String>() {{
                add("NetFlow.NetFlowDevicesByBytesAndPackets");
                add("NetFlow.NetFlowInputInterfacesByBytesAndPackets");
                add("NetFlow.NetFlowOutputInterfacesByBytesAndPackets");
                add("NetFlow.NetFlowInterfacePairsByBytesAndPackets");
                add("IPConversations");
                add("NetFlow.NetFlowTopProtocolAndEtherTypesByBytesAndPackets");
                add("TopSourcesByBytesAndPackets");
                add("TopApplicationPortsByBytesAndPackets");
                add("TopCountryPairsByBytesAndPackets");
                add("NetFlow.NetFlowSummaryByBytesAndPackets");
            }});
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