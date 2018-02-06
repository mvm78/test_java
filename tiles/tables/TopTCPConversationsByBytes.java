package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPConversationsByBytes extends Table {

    //**************************************************************************

    public TopTCPConversationsByBytes() {

        final CommonTopHostPairs commonInstance = new CommonTopHostPairs();
        final CommonByTCPBytes commonByInstance = new CommonByTCPBytes();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("Top TCP Conversations by Bytes");
        this.setPrefix("TcpAgg flowsegments");
    }

    //**************************************************************************

}