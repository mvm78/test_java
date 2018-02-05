package test_java.tiles.tables;

import test_java.tiles.common.CommonNetwork;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetworkSessions extends Table {

    //**************************************************************************

    public NetworkSessions() {

        CommonNetwork CommonInstance = new CommonNetwork();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Network - Sessions");
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}