package test_java.tiles.tables;

import test_java.tiles.common.CommonTopCountryPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopCountryPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopCountryPairsByBytesAndPackets() {

        this.common = new CommonTopCountryPairs();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.title = "Top Country Pair by Packets and Bytes";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}