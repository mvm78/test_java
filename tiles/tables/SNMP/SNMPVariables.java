package test_java.tiles.tables.SNMP;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonDestinationPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class SNMPVariables extends Table {

    //**************************************************************************

    public SNMPVariables() {

        this.common = new CommonDestinationPorts();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "SNMP - Variables";
        this.prefix = "NetDist";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}