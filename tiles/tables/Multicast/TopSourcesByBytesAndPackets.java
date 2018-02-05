package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopSources;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopSourcesByBytesAndPackets extends Table {

    //**************************************************************************

    public TopSourcesByBytesAndPackets() {

        this.common = new CommonTopSources();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.title = "Multicast - Top Sources";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}