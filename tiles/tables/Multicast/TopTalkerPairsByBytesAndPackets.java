package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopTalkerPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopTalkerPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopTalkerPairsByBytesAndPackets() {

        final CommonTopTalkerPairs commonInstance = new CommonTopTalkerPairs();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("Multicast - Talker Pairs");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}