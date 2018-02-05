package test_java.tiles.tables;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopApplicationPortsByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopApplicationPortsByResponseTimeAndRetransmittedBytes() {

        final CommonTopApplicationPorts CommonInstance = new CommonTopApplicationPorts();
        final CommonByResponseTimeAndRetransmittedBytes CommonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);

        final String [] instanceFilters = this.getCommon().getFilters();
        final LinkedHashMap<String, HashMap<String, Object>> instanceFilterColumns =
                this.getCommon().getFilterColumns();

        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by ResponseTime (Retransmitted Bytes)");
        this.setPrefix("TcpAgg flowsegments");
        this.setFields(new String [] {
            "dport " + this.getCommonBy().getFields(),
        });
        this.setFilters(instanceFilters);
        this.setFilterColumns(instanceFilterColumns);
        this.columns = this.getCommonBy().appendCompareColumns(instanceFilterColumns, 1);
    }

    //**************************************************************************

}