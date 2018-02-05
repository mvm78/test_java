package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTopDevices;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowDevicesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowDevicesByBytesAndPackets() {

        final CommonTopDevices CommonInstance = new CommonTopDevices();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Netflow - Devices");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}