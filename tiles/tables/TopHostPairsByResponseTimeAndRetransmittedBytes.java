package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopHostPairsByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopHostPairsByResponseTimeAndRetransmittedBytes() {

        final CommonTopHostPairs CommonInstance = new CommonTopHostPairs();
        final CommonByResponseTimeAndRetransmittedBytes CommonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top Host Pairs by ResponseTime (Retransmitted Bytes)");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}