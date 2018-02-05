package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonTopInterfacePairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowInterfacePairsByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowInterfacePairsByBytesAndPackets() {

        CommonTopInterfacePairs CommonInstance = new CommonTopInterfacePairs();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Netflow - Ifaces Pair");
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}