package test_java.tiles.charts.SNMP;

import test_java.tiles.charts.*;
import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPVariablesChart extends Chart {

    //**************************************************************************

    public SNMPVariablesChart() {

        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(commonByInstance);
        this.setTitle("SNMP - Variables");
        this.setPrefix("NetDist");
        this.setCommonByData();
    }

    //**************************************************************************

}