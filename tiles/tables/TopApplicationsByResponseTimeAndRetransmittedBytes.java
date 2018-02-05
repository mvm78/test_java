package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplications;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopApplicationsByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopApplicationsByResponseTimeAndRetransmittedBytes() {

        CommonTopTCPApplications CommonInstance = new CommonTopTCPApplications();
        CommonByResponseTimeAndRetransmittedBytes CommonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Applications by ResponseTime (Retransmitted Bytes)");
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}