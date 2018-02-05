package test_java.tiles.tables;

import test_java.tiles.common.CommonNetwork;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetworkSessions extends Table {

    //**************************************************************************

    public NetworkSessions() {

        final CommonNetwork CommonInstance = new CommonNetwork();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Network - Sessions");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}