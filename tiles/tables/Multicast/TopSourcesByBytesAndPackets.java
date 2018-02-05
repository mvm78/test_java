package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopSources;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopSourcesByBytesAndPackets extends Table {

    //**************************************************************************

    public TopSourcesByBytesAndPackets() {

        final CommonTopSources CommonInstance = new CommonTopSources();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Multicast - Top Sources");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}