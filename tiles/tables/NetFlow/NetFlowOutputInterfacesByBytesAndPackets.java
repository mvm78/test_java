package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonTopInputInterfaces;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowOutputInterfacesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowOutputInterfacesByBytesAndPackets() {

        final CommonTopInputInterfaces commonInstance = new CommonTopInputInterfaces();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setIsSingleLine(true);
        this.setTitle("Netflow - Output Interfaces");
        this.setPrefix("NetDist");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}