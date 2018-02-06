package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPServersByBytes extends Table {

    //**************************************************************************

    public TopTCPServersByBytes() {

        final CommonTopServers commonInstance = new CommonTopServers();
        final CommonByTCPBytes commonByInstance = new CommonByTCPBytes();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("Top TCP Servers by Bytes");
        this.setPrefix("TcpAgg flowsegments");
    }

    //**************************************************************************

}