package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPServersByBytes extends Table {

    //**************************************************************************

    public TopTCPServersByBytes() {

        this.common = new CommonTopServers();
        this.commonBy = new CommonByTCPBytes();

        this.isSingleLine = true;
        this.title = "Top TCP Servers by Bytes";
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