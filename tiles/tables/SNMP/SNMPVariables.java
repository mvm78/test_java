package test_java.tiles.tables.SNMP;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonDestinationPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPVariables extends Table {

    //**************************************************************************

    public SNMPVariables() {

        CommonDestinationPorts CommonInstance = new CommonDestinationPorts();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "SNMP - Variables";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}