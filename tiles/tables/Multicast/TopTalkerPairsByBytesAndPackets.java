package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopTalkerPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopTalkerPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopTalkerPairsByBytesAndPackets() {

        final CommonTopTalkerPairs CommonInstance = new CommonTopTalkerPairs();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Multicast - Talker Pairs");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}