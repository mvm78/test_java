package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplications;
import test_java.tiles.common.CommonByThroughput;

public class TopApplicationsByThroughput extends Table {

    //**************************************************************************

    public TopApplicationsByThroughput() {

        final CommonTopTCPApplications commonInstance = new CommonTopTCPApplications();
        final CommonByThroughput commonByInstance = new CommonByThroughput();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Applications by Throughput");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}