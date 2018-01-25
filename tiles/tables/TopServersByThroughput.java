package test_java.tiles.tables;

import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByThroughput;

public class TopServersByThroughput extends Table {

    //**************************************************************************

    public TopServersByThroughput() {

        this.common = new CommonTopServers();
        this.commonBy = new CommonByThroughput();

        this.title = "Top Servers by Throughput";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}