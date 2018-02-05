package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonNetFlowSummary;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowSummaryByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowSummaryByBytesAndPackets() {

        CommonNetFlowSummary CommonInstance = new CommonNetFlowSummary();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Netflow - Summary";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}