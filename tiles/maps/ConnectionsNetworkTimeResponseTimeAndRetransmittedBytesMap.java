package test_java.tiles.maps;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTopCountries;
import test_java.tiles.common.CommonByResponseTimeAndRetransmittedBytes;

public class ConnectionsNetworkTimeResponseTimeAndRetransmittedBytesMap extends Table {

    //**************************************************************************

    public ConnectionsNetworkTimeResponseTimeAndRetransmittedBytesMap() {

        final CommonTopCountries commonInstance = new CommonTopCountries();
        final CommonByResponseTimeAndRetransmittedBytes commonByInstance =
                new CommonByResponseTimeAndRetransmittedBytes();

        this.setTitle("Connections, Network Time, Response Time, and Retransmitted Bytes Map");
        this.setPrefix("TcpAgg flowsegments");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}