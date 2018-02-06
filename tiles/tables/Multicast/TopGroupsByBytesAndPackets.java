package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopGroups;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopGroupsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopGroupsByBytesAndPackets() {

        final CommonTopGroups commonInstance = new CommonTopGroups();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("Multicast - Top Groups");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}