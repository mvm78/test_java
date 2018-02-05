package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByThroughput;

public class TopApplicationPortsByThroughput extends Table {

    //**************************************************************************

    public TopApplicationPortsByThroughput() {

        final CommonTopApplicationPorts CommonInstance = new CommonTopApplicationPorts();
        final CommonByThroughput CommonByInstance = new CommonByThroughput();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);

        final String [] instanceFilters = this.getCommon().getFilters();

        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by Throughput");
        this.setPrefix("TcpAgg flowsegments");
        this.setFields(new String [] {
            "dport " + this.getCommonBy().getFields(),
        });
        this.setFilters(instanceFilters);
        this.filterColumns = this.getCommon().getFilterColumns();
        this.columns = this.getCommonBy().appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}