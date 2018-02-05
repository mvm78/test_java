package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.NetFlow.CommonTopInputInterfaces;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowOutputInterfacesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowOutputInterfacesByBytesAndPackets() {

        final CommonTopInputInterfaces CommonInstance = new CommonTopInputInterfaces();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Netflow - Output Interfaces");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}