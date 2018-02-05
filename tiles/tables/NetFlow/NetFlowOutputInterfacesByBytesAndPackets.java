package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonTopInputInterfaces;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowOutputInterfacesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowOutputInterfacesByBytesAndPackets() {

        this.common = new CommonTopInputInterfaces();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Netflow - Output Interfaces";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}