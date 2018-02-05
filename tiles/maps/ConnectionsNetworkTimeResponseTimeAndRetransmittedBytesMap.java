package test_java.tiles.maps;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTopCountries;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class ConnectionsNetworkTimeResponseTimeAndRetransmittedBytesMap extends Table {

    //**************************************************************************

    public ConnectionsNetworkTimeResponseTimeAndRetransmittedBytesMap() {

        final CommonTopCountries CommonInstance = new CommonTopCountries();
        final CommonByResponseTimeAndRetransmittedBytes CommonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommonBy(CommonByInstance);
        this.setCommon(CommonInstance);
        this.setTitle("Connections, Network Time, Response Time, and Retransmitted Bytes Map");
        this.setPrefix("TcpAgg flowsegments");
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.getCommon().getFilters();
        this.filterColumns = this.getCommon().getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}