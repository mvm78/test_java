package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class IPConversations extends Table {

    //**************************************************************************

    public IPConversations() {

        CommonTopHostPairs CommonInstance = new CommonTopHostPairs();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("IP Conversations");
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}