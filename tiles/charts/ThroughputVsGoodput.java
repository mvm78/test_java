package test_java.tiles.charts;

import test_java.tiles.common.CommonByThroughput;

public class ThroughputVsGoodput extends Chart {

    //**************************************************************************

    public ThroughputVsGoodput() {

        final CommonByThroughput commonByInstance = new CommonByThroughput();

        this.setCommonBy(commonByInstance);
        this.setTitle("Throughput vs Goodput");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonByData();
    }

    //**************************************************************************

}