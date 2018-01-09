package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplications;
import test_java.tiles.common.CommonByThroughput;

public class TopApplicationsByThroughput extends Table {

    //**************************************************************************

    public TopApplicationsByThroughput() {

        this.common = new CommonTopApplications();
        this.commonBy = new CommonByThroughput();

        this.isSingleLine = true;
        this.title = "Top Applications by Throughput";
        this.prefix = "TcpAgg flowsegments";
        this.fields = new String [] {
            "dport " + this.commonBy.getFields(),
            "apptype " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}