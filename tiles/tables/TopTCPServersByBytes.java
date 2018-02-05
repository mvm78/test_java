package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPServersByBytes extends Table {

    //**************************************************************************

    public TopTCPServersByBytes() {

        CommonTopServers CommonInstance = new CommonTopServers();
        CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Top TCP Servers by Bytes";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}