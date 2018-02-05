package test_java.tiles.tables;

import test_java.tiles.common.CommonNetwork;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetworkSessions extends Table {

    //**************************************************************************

    public NetworkSessions() {

        this.common = new CommonNetwork();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.title = "Network - Sessions";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}