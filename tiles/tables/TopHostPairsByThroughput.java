package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByThroughput;

public class TopHostPairsByThroughput extends Table {

    //**************************************************************************

    public TopHostPairsByThroughput() {

        CommonTopHostPairs CommonInstance = new CommonTopHostPairs();
        CommonByThroughput CommonByInstance = new CommonByThroughput();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Top Host Pairs by Throughput";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}