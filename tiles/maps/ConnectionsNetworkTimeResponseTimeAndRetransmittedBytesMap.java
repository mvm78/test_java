package test_java.tiles.maps;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTopCountries;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class ConnectionsNetworkTimeResponseTimeAndRetransmittedBytesMap extends Table {

    //**************************************************************************

    public ConnectionsNetworkTimeResponseTimeAndRetransmittedBytesMap() {

        this.common = new CommonTopCountries();
        this.commonBy = new CommonByResponseTimeAndRetransmittedBytes();

        this.title = "Connections, Network Time, Response Time, and Retransmitted Bytes Map";
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