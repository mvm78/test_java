package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplicationPorts;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class TopApplicationPortsByResponseTimeAndRetransmittedBytes extends Table {

    //**************************************************************************

    public TopApplicationPortsByResponseTimeAndRetransmittedBytes() {

        final CommonTopTCPApplicationPorts commonInstance =
                new CommonTopTCPApplicationPorts();
        final CommonByResponseTimeAndRetransmittedBytes commonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by ResponseTime (Retransmitted Bytes)");
        this.setPrefix("TcpAgg flowsegments");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}