package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplicationPorts;
import test_java.tiles.common.CommonByThroughput;

public class TopApplicationPortsByThroughput extends Table {

    //**************************************************************************

    public TopApplicationPortsByThroughput() {

        final CommonTopTCPApplicationPorts commonInstance =
                new CommonTopTCPApplicationPorts();
        final CommonByThroughput commonByInstance = new CommonByThroughput();

        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by Throughput");
        this.setPrefix("TcpAgg flowsegments");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}