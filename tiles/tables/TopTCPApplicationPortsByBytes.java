package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPApplicationPortsByBytes extends Table {

    //**************************************************************************

    public TopTCPApplicationPortsByBytes() {

        CommonTopApplicationPorts CommonInstance = new CommonTopApplicationPorts();
        CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Top TCP Application Ports by Bytes";
        this.prefix = "TcpAgg flowsegments";
        this.fields = new String [] {
            "dport " + this.commonBy.getFields(),
        };
        this.filters = this.getCommon().getFilters();
        this.filterColumns = this.getCommon().getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}