package test_java.tiles.charts;

import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes extends Chart {

    //**************************************************************************

    public ConnectionsNetworkTimeResponseTimeAndRetransmittedBytes() {

        final CommonByResponseTimeAndRetransmittedBytes commonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setTitle("Connections, Network Time, Response Time, and Retransmitted Bytes");
        this.setPrefix("TcpAgg flowsegments");

        this.setCommonByData(commonByInstance);
    }

    //**************************************************************************

}