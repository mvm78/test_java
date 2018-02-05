package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopGroups;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopGroupsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopGroupsByBytesAndPackets() {

        CommonTopGroups CommonInstance = new CommonTopGroups();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Multicast - Top Groups";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}