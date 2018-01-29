package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByThroughput;

public class TopHostPairsByThroughput extends Table {

    //**************************************************************************

    public TopHostPairsByThroughput() {

        this.common = new CommonTopHostPairs();
        this.commonBy = new CommonByThroughput();

        this.title = "Top Host Pairs by Throughput";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}