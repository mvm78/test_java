package test_java.tiles.tables;

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

        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by ResponseTime (Retransmitted Bytes)");
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