package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTopDevices;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowDevicesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowDevicesByBytesAndPackets() {

        this.common = new CommonTopDevices();
        this.commonBy = new CommonByBytesAndPackets();

        this.isSingleLine = true;
        this.title = "Netflow - Devices";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}