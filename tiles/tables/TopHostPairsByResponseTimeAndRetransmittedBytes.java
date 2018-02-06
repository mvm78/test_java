package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopHostPairsByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopHostPairsByResponseTimeAndRetransmittedBytes() {

        final CommonTopHostPairs commonInstance = new CommonTopHostPairs();
        final CommonByResponseTimeAndRetransmittedBytes commonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("Top Host Pairs by ResponseTime (Retransmitted Bytes)");
        this.setPrefix("TcpAgg flowsegments");
    }

    //**************************************************************************

}