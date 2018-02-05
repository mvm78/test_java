package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPApplicationPortsByBytes extends Table {

    //**************************************************************************

    public TopTCPApplicationPortsByBytes() {

        final CommonTopApplicationPorts CommonInstance = new CommonTopApplicationPorts();
        final CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top TCP Application Ports by Bytes");
        this.setPrefix("TcpAgg flowsegments");
        this.setFields(new String [] {
            "dport " + this.getCommonBy().getFields(),
        });
        this.filters = this.getCommon().getFilters();
        this.filterColumns = this.getCommon().getFilterColumns();
        this.columns = this.getCommonBy().appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}