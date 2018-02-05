package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonTopInputInterfaces;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowInputInterfacesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowInputInterfacesByBytesAndPackets() {

        this.common = new CommonTopInputInterfaces();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Netflow - Input Interfaces";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}