package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationsHostPairsAndPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class Flows extends Table {

    //**************************************************************************

    public Flows() {

        this.common = new CommonTopApplicationsHostPairsAndPorts();
        this.commonBy = new CommonByBytesAndPackets();

        this.isSingleLine = true;
        this.title = "Flows";
        this.prefix = "NetDist";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
            this.common.getFields()[1] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}