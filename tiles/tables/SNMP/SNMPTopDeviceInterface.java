package test_java.tiles.tables.SNMP;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonDeviceInterface;
import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPTopDeviceInterface extends Table {

    //**************************************************************************

    public SNMPTopDeviceInterface() {

        final CommonDeviceInterface commonInstance = new CommonDeviceInterface();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("SNMP - Top Device Interface");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}