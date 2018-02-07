package test_java.tiles.tables;

import test_java.tiles.common.CommonTopCountryPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopCountryPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopCountryPairsByBytesAndPackets() {

        final CommonTopCountryPairs commonInstance = new CommonTopCountryPairs();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setTitle("Top Country Pair by Packets and Bytes");
        this.setPrefix("NetDist");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}