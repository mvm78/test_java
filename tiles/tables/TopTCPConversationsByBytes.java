package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPConversationsByBytes extends Table {

    //**************************************************************************

    public TopTCPConversationsByBytes() {

        CommonTopHostPairs CommonInstance = new CommonTopHostPairs();
        CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Top TCP Conversations by Bytes";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}