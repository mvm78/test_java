package test_java.tiles.charts;

import test_java.tiles.common.CommonByThroughput;

public class ThroughputVsGoodput extends Chart {

    //**************************************************************************

    public ThroughputVsGoodput() {

        this.commonBy = new CommonByThroughput();

        this.title = "Throughput vs Goodput";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonByData();
    }

    //**************************************************************************

}