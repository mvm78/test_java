package test_java.tiles.tables.SNMP;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonDeviceInterface;
import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPTopDeviceInterface extends Table {

    //**************************************************************************

    public SNMPTopDeviceInterface() {

        CommonDeviceInterface CommonInstance = new CommonDeviceInterface();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SNMP - Top Device Interface");
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}