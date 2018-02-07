package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopServersByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopServersByResponseTimeAndRetransmittedBytes() {

        final CommonTopServers commonInstance = new CommonTopServers();
        final CommonByResponseTimeAndRetransmittedBytes commonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setTitle("Top Servers by ResponseTime (Retransmitted Bytes)");
        this.setPrefix("TcpAgg flowsegments");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}