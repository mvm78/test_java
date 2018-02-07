package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class IPConversations extends Table {

    //**************************************************************************

    public IPConversations() {

        final CommonTopHostPairs commonInstance = new CommonTopHostPairs();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setTitle("IP Conversations");
        this.setPrefix("NetDist");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}