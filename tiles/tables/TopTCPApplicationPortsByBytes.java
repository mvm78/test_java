package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPApplicationPortsByBytes extends Table {

    //**************************************************************************

    public TopTCPApplicationPortsByBytes() {

        this.common = new CommonTopApplicationPorts();
        this.commonBy = new CommonByTCPBytes();

        this.isSingleLine = true;
        this.title = "Top TCP Application Ports by Bytes";
        this.prefix = "TcpAgg flowsegments";
        this.fields = new String [] {
            "dport " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}