package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonNetFlowSummary;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowSummaryByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowSummaryByBytesAndPackets() {

        final CommonNetFlowSummary commonInstance = new CommonNetFlowSummary();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setTitle("Netflow - Summary");
        this.setPrefix("NetDist");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}