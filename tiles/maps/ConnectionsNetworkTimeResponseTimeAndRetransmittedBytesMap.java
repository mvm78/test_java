package test_java.tiles.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;

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

        final String [] instanceFilters = this.getCommon().getFilters();
        final LinkedHashMap<String, HashMap<String, Object>> instanceFilterColumns =
                this.getCommon().getFilterColumns();
        final LinkedHashMap<String, HashMap<String, Object>> instanceColumns =
                this.getCommonBy().appendCompareColumns(instanceFilterColumns, 1);

        this.setTitle("Connections, Network Time, Response Time, and Retransmitted Bytes Map");
        this.setPrefix("TcpAgg flowsegments");
        this.setFields(new String [] {
            this.getCommon().getField(0) + " " + this.getCommonBy().getFields(),
        });
        this.setFilters(instanceFilters);
        this.setFilterColumns(instanceFilterColumns);
        this.setColumns(instanceColumns);
    }

    //**************************************************************************

}