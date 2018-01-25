package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopTalkerPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopTalkerPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopTalkerPairsByBytesAndPackets() {

        this.common = new CommonTopTalkerPairs();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "Multicast - Talker Pairs";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}