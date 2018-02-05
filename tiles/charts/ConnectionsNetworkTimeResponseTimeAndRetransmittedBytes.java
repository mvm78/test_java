package test_java.tiles.charts;

import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes extends Chart {

    //**************************************************************************

    public ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes() {

        CommonByResponseTimeAndRetransmittedBytes CommonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommonBy(CommonByInstance);
        this.setTitle("Connections, Network Time, Response Time, and Retransmitted Bytes");
        this.prefix = "TcpAgg flowsegments";
        this.setCommonByData();
        this.minWindow = 1;
    }

    //**************************************************************************

}