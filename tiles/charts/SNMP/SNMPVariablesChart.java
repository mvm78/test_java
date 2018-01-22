package test_java.tiles.charts.SNMP;

import test_java.tiles.charts.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPVariablesChart extends Chart {

    //**************************************************************************

    public SNMPVariablesChart() {

        this.commonBy = new CommonByBytesAndPackets();

        this.title = "SNMP - Variables";
        this.prefix = "NetDist";
        this.fields = new String [] {
            this.commonBy.getFields(),
        };
        this.filters = new String [] {};
        this.columns = this.commonBy.appendCompareColumns(
                new LinkedHashMap<String, HashMap<String, Object>>() {}, 1
        );
    }

    //**************************************************************************

}