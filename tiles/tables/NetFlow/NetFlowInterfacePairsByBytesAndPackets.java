package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonTopInterfacePairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowInterfacePairsByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowInterfacePairsByBytesAndPackets() {

        final CommonTopInterfacePairs commonInstance = new CommonTopInterfacePairs();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommonData(commonInstance, commonByInstance);

        this.setIsSingleLine(true);
        this.setTitle("Netflow - Ifaces Pair");
        this.setPrefix("NetDist");
    }

    //**************************************************************************

}