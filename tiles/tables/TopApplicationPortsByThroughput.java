package test_java.tiles.tables;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByThroughput;

public class TopApplicationPortsByThroughput extends Table {

    //**************************************************************************

    public TopApplicationPortsByThroughput() {

        final CommonTopApplicationPorts commonInstance = new CommonTopApplicationPorts();
        final CommonByThroughput commonByInstance = new CommonByThroughput();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);

        final String [] instanceFilters = this.getCommon().getFilters();
        final LinkedHashMap<String, HashMap<String, Object>> instanceFilterColumns =
                this.getCommon().getFilterColumns();
        final LinkedHashMap<String, HashMap<String, Object>> instanceColumns =
                this.getCommonBy().appendCompareColumns(instanceFilterColumns, 1);

        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by Throughput");
        this.setPrefix("TcpAgg flowsegments");
        this.setFields(new String [] {
            "dport " + this.getCommonBy().getFields(),
        });
        this.setFilters(instanceFilters);
        this.setFilterColumns(instanceFilterColumns);
        this.setColumns(instanceColumns);
    }

    //**************************************************************************

}