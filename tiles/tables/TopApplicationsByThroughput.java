package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplications;
import test_java.tiles.common.CommonByThroughput;

public class TopApplicationsByThroughput extends Table {

    //**************************************************************************

    public TopApplicationsByThroughput() {

        final CommonTopTCPApplications commonInstance = new CommonTopTCPApplications();
        final CommonByThroughput commonByInstance = new CommonByThroughput();

        this.setCommonData(commonInstance, commonByInstance);

        this.setIsSingleLine(true);
        this.setTitle("Top Applications by Throughput");
        this.setPrefix("TcpAgg flowsegments");
    }

    //**************************************************************************

}