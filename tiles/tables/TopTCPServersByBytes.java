package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPServersByBytes extends Table {

    //**************************************************************************

    public TopTCPServersByBytes() {

        final CommonTopServers CommonInstance = new CommonTopServers();
        final CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top TCP Servers by Bytes");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}