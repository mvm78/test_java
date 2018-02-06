package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByThroughput;

public class TopHostPairsByThroughput extends Table {

    //**************************************************************************

    public TopHostPairsByThroughput() {

        final CommonTopHostPairs commonInstance = new CommonTopHostPairs();
        final CommonByThroughput commonByInstance = new CommonByThroughput();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("Top Host Pairs by Throughput");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}