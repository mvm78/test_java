package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByThroughput;

public class TopServersByThroughput extends Table {

    //**************************************************************************

    public TopServersByThroughput() {

        final CommonTopServers commonInstance = new CommonTopServers();
        final CommonByThroughput commonByInstance = new CommonByThroughput();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("Top Servers by Throughput");
        this.setPrefix("TcpAgg flowsegments");
    }

    //**************************************************************************

}