package test_java.tiles.charts;

import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes extends Chart {

    //**************************************************************************

    public ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes() {

        this.commonBy = new CommonByResponseTimeAndRetransmittedBytes();

        this.title = "Connections, Network Time, Response Time, and Retransmitted Bytes";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonByData();
        this.minWindow = 1;
    }

    //**************************************************************************

}