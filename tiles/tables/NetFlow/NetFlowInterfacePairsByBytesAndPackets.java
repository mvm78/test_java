package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonTopInterfacePairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowInterfacePairsByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowInterfacePairsByBytesAndPackets() {

        this.common = new CommonTopInterfacePairs();
        this.commonBy = new CommonByBytesAndPackets();

        this.isSingleLine = true;
        this.title = "Netflow - Ifaces Pair";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}