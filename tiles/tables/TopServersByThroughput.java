package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByThroughput;

public class TopServersByThroughput extends Table {

    //**************************************************************************

    public TopServersByThroughput() {

        final CommonTopServers CommonInstance = new CommonTopServers();
        final CommonByThroughput CommonByInstance = new CommonByThroughput();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top Servers by Throughput");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}