package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopHostPairsByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopHostPairsByResponseTimeAndRetransmittedBytes() {

        this.common = new CommonTopHostPairs();

        CommonByResponseTimeAndRetransmittedBytes CommonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommonBy(CommonByInstance);
        this.title = "Top Host Pairs by ResponseTime (Retransmitted Bytes)";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}