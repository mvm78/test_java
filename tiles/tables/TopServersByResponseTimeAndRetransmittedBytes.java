package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopServersByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopServersByResponseTimeAndRetransmittedBytes() {

        CommonTopServers CommonInstance = new CommonTopServers();
        CommonByResponseTimeAndRetransmittedBytes CommonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Top Servers by ResponseTime (Retransmitted Bytes)";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}