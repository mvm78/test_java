package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopSources;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopSourcesByBytesAndPackets extends Table {

    //**************************************************************************

    public TopSourcesByBytesAndPackets() {

        final CommonTopSources commonInstance = new CommonTopSources();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("Multicast - Top Sources");
        this.setPrefix("NetDist");
    }

    //**************************************************************************

}