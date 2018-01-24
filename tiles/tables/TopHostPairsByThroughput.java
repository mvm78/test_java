package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByThroughput;

public class TopHostPairsByThroughput extends Table {

    //**************************************************************************

    public TopHostPairsByThroughput() {

        this.common = new CommonTopHostPairs();
        this.commonBy = new CommonByThroughput();

        this.isSingleLine = true;
        this.title = "Top Host Pairs by Throughput";
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