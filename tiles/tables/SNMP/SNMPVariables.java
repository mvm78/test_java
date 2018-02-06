package test_java.tiles.tables.SNMP;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonDestinationPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPVariables extends Table {

    //**************************************************************************

    public SNMPVariables() {

        final CommonDestinationPorts commonInstance = new CommonDestinationPorts();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("SNMP - Variables");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}