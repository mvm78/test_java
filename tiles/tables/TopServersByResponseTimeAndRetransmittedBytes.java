package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopServersByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopServersByResponseTimeAndRetransmittedBytes() {

        final CommonTopServers CommonInstance = new CommonTopServers();
        final CommonByResponseTimeAndRetransmittedBytes CommonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top Servers by ResponseTime (Retransmitted Bytes)");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}