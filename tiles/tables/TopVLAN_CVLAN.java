package test_java.tiles.tables;

import test_java.tiles.common.CommonVLAN_CVLAN;
import test_java.tiles.common.CommonByTCPBytes;

public class TopVLAN_CVLAN extends Table {

    //**************************************************************************

    public TopVLAN_CVLAN() {

        final CommonVLAN_CVLAN CommonInstance = new CommonVLAN_CVLAN();
        final CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top VLAN");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}