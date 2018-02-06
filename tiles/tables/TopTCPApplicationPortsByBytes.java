package test_java.tiles.tables;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPApplicationPortsByBytes extends Table {

    //**************************************************************************

    public TopTCPApplicationPortsByBytes() {

        final CommonTopApplicationPorts commonInstance = new CommonTopApplicationPorts();
        final CommonByTCPBytes commonByInstance = new CommonByTCPBytes();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);

        final String [] instanceFilters = this.getCommon().getFilters();
        final LinkedHashMap<String, HashMap<String, Object>> instanceFilterColumns =
                this.getCommon().getFilterColumns();
        final LinkedHashMap<String, HashMap<String, Object>> instanceColumns =
                this.getCommonBy().appendCompareColumns(instanceFilterColumns, 1);

        this.setIsSingleLine(true);
        this.setTitle("Top TCP Application Ports by Bytes");
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