package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplications;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPApplicationsByBytes extends Table {

    //**************************************************************************

    public TopTCPApplicationsByBytes() {

        final CommonTopTCPApplications commonInstance = new CommonTopTCPApplications();
        final CommonByTCPBytes commonByInstance = new CommonByTCPBytes();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top TCP Applications by Bytes");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}