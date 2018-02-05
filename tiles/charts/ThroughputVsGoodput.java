package test_java.tiles.charts;

import test_java.tiles.common.CommonByThroughput;

public class ThroughputVsGoodput extends Chart {

    //**************************************************************************

    public ThroughputVsGoodput() {

        final CommonByThroughput CommonByInstance = new CommonByThroughput();

        this.setCommonBy(CommonByInstance);
        this.setTitle("Throughput vs Goodput");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonByData();
    }

    //**************************************************************************

}