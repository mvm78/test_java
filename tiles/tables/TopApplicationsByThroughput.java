package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplications;
import test_java.tiles.common.CommonByThroughput;

public class TopApplicationsByThroughput extends Table {

    //**************************************************************************

    public TopApplicationsByThroughput() {

        CommonTopTCPApplications CommonInstance = new CommonTopTCPApplications();
        CommonByThroughput CommonByInstance = new CommonByThroughput();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Applications by Throughput");
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}