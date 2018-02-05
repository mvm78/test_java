package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByThroughput;

public class TopServersByThroughput extends Table {

    //**************************************************************************

    public TopServersByThroughput() {

        CommonTopServers CommonInstance = new CommonTopServers();
        CommonByThroughput CommonByInstance = new CommonByThroughput();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Top Servers by Throughput";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}