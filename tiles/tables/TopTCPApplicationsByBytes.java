package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplications;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPApplicationsByBytes extends Table {

    //**************************************************************************

    public TopTCPApplicationsByBytes() {

        final CommonTopTCPApplications CommonInstance = new CommonTopTCPApplications();
        final CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top TCP Applications by Bytes");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}