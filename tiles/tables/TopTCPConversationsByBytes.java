package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPConversationsByBytes extends Table {

    //**************************************************************************

    public TopTCPConversationsByBytes() {

        this.common = new CommonTopHostPairs();
        this.commonBy = new CommonByTCPBytes();

        this.title = "Top TCP Conversations by Bytes";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}