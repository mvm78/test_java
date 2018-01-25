package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class IPConversations extends Table {

    //**************************************************************************

    public IPConversations() {

        this.common = new CommonTopHostPairs();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "IP Conversations";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}