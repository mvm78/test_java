package test_java.tiles.tables.SNMP;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonDestinationPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPVariables extends Table {

    //**************************************************************************

    public SNMPVariables() {

        final CommonDestinationPorts CommonInstance = new CommonDestinationPorts();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SNMP - Variables");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}