package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplications;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPApplicationsByBytes extends Table {

    //**************************************************************************

    public TopTCPApplicationsByBytes() {

        CommonTopTCPApplications CommonInstance = new CommonTopTCPApplications();
        CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Top TCP Applications by Bytes";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}