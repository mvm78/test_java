package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonTopInputInterfaces;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowOutputInterfacesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowOutputInterfacesByBytesAndPackets() {

        CommonTopInputInterfaces CommonInstance = new CommonTopInputInterfaces();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Netflow - Output Interfaces";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}