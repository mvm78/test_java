package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplications;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopApplicationsByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopApplicationsByResponseTimeAndRetransmittedBytes() {

        final CommonTopTCPApplications commonInstance = new CommonTopTCPApplications();
        final CommonByResponseTimeAndRetransmittedBytes commonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommonData(commonInstance, commonByInstance);

        this.setIsSingleLine(true);
        this.setTitle("Top Applications by ResponseTime (Retransmitted Bytes)");
        this.setPrefix("TcpAgg flowsegments");
    }

    //**************************************************************************

}