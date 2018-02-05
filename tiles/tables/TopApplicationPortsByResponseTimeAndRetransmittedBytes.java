package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopApplicationPortsByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopApplicationPortsByResponseTimeAndRetransmittedBytes() {

        CommonTopApplicationPorts CommonInstance = new CommonTopApplicationPorts();
        CommonByResponseTimeAndRetransmittedBytes CommonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by ResponseTime (Retransmitted Bytes)");
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