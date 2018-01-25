package test_java.tiles.tables.SNMP;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonDeviceInterface;
import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPTopDeviceInterface extends Table {

    //**************************************************************************

    public SNMPTopDeviceInterface() {

        this.common = new CommonDeviceInterface();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "SNMP - Top Device Interface";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}