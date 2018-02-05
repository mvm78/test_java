package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByThroughput;

public class TopHostPairsByThroughput extends Table {

    //**************************************************************************

    public TopHostPairsByThroughput() {

        final CommonTopHostPairs CommonInstance = new CommonTopHostPairs();
        final CommonByThroughput CommonByInstance = new CommonByThroughput();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top Host Pairs by Throughput");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}