package test_java.tiles.charts;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes extends Chart {

    //**************************************************************************

    public ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes() {

        this.commonBy = new CommonByResponseTimeAndRetransmittedBytes();

        this.title = "Connections, Network Time, Response Time, and Retransmitted Bytes";
        this.prefix = "TcpAgg flowsegments";
        this.fields = new String [] {
            this.commonBy.getFields(),
        };
        this.filters = new String [] {};
        this.columns = this.commonBy.appendCompareColumns(
                new LinkedHashMap<String, HashMap<String, Object>>() {}, 1
        );
        this.minWindow = 1;
    }

    //**************************************************************************

}