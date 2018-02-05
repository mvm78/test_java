package test_java.tiles.charts;

import test_java.tiles.common.CommonByThroughput;

public class ThroughputVsGoodput extends Chart {

    //**************************************************************************

    public ThroughputVsGoodput() {

        CommonByThroughput CommonByInstance = new CommonByThroughput();

        this.setCommonBy(CommonByInstance);
        this.title = "Throughput vs Goodput";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonByData();
    }

    //**************************************************************************

}