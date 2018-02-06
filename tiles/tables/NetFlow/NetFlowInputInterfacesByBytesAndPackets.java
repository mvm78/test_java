package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonTopInputInterfaces;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowInputInterfacesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowInputInterfacesByBytesAndPackets() {

        final CommonTopInputInterfaces commonInstance = new CommonTopInputInterfaces();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Netflow - Input Interfaces");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}