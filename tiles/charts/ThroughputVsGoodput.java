package test_java.tiles.charts;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.CommonByThroughput;

public class ThroughputVsGoodput extends Chart {

    //**************************************************************************

    public ThroughputVsGoodput() {

        this.commonBy = new CommonByThroughput();

        this.title = "Throughput vs Goodput";
        this.prefix = "TcpAgg flowsegments";
        this.fields = new String [] {
            this.commonBy.getFields(),
        };
        this.filters = new String [] {};
        this.columns = this.commonBy.appendCompareColumns(
                new LinkedHashMap<String, HashMap<String, Object>>() {}, 1
        );
    }

    //**************************************************************************

}