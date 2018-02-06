package test_java.tiles.tables;

import test_java.tiles.common.CommonNetwork;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetworkSessions extends Table {

    //**************************************************************************

    public NetworkSessions() {

        final CommonNetwork commonInstance = new CommonNetwork();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("Network - Sessions");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}