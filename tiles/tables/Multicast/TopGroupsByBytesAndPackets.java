package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopGroups;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopGroupsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopGroupsByBytesAndPackets() {

        final CommonTopGroups CommonInstance = new CommonTopGroups();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Multicast - Top Groups");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}