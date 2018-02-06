package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTopDevices;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowDevicesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowDevicesByBytesAndPackets() {

        final CommonTopDevices commonInstance = new CommonTopDevices();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Netflow - Devices");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}