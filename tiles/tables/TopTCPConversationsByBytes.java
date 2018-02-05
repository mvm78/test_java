package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPConversationsByBytes extends Table {

    //**************************************************************************

    public TopTCPConversationsByBytes() {

        final CommonTopHostPairs CommonInstance = new CommonTopHostPairs();
        final CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top TCP Conversations by Bytes");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}