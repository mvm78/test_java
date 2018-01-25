package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopServersByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopServersByResponseTimeAndRetransmittedBytes() {

        this.common = new CommonTopServers();
        this.commonBy = new CommonByResponseTimeAndRetransmittedBytes();

        this.title = "Top Servers by ResponseTime (Retransmitted Bytes)";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}