package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopTalkerPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopTalkerPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopTalkerPairsByBytesAndPackets() {

        CommonTopTalkerPairs CommonInstance = new CommonTopTalkerPairs();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Multicast - Talker Pairs";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}