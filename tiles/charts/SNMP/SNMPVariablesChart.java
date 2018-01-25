package test_java.tiles.charts.SNMP;

import test_java.tiles.charts.*;

import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPVariablesChart extends Chart {

    //**************************************************************************

    public SNMPVariablesChart() {

        this.commonBy = new CommonByBytesAndPackets();

        this.title = "SNMP - Variables";
        this.prefix = "NetDist";
        this.setCommonByData();
    }

    //**************************************************************************

}