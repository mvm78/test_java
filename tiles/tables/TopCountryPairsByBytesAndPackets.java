package test_java.tiles.tables;

import test_java.tiles.common.CommonTopCountryPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopCountryPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopCountryPairsByBytesAndPackets() {

        final CommonTopCountryPairs CommonInstance = new CommonTopCountryPairs();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top Country Pair by Packets and Bytes");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}