package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByThroughput;

public class TopApplicationPortsByThroughput extends Table {

    //**************************************************************************

    public TopApplicationPortsByThroughput() {

        CommonTopApplicationPorts CommonInstance = new CommonTopApplicationPorts();
        CommonByThroughput CommonByInstance = new CommonByThroughput();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by Throughput");
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