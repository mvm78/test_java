package test_java.tiles.tables;

import test_java.tiles.common.CommonVLAN_CVLAN;
import test_java.tiles.common.CommonByTCPBytes;

public class TopVLAN_CVLAN extends Table {

    //**************************************************************************

    public TopVLAN_CVLAN() {

        this.common = new CommonVLAN_CVLAN();
        this.commonBy = new CommonByTCPBytes();

        this.isSingleLine = true;
        this.title = "Top VLAN";
        this.prefix = "TcpAgg flowsegments";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}