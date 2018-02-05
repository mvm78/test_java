package test_java.tiles.tables.SNMP;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonDeviceInterface;
import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPTopDeviceInterface extends Table {

    //**************************************************************************

    public SNMPTopDeviceInterface() {

        final CommonDeviceInterface CommonInstance = new CommonDeviceInterface();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SNMP - Top Device Interface");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}