package test_java.tiles.tables;

import test_java.tiles.common.CommonVLAN_CVLAN;
import test_java.tiles.common.CommonByTCPBytes;

public class TopVLAN_CVLAN extends Table {

    //**************************************************************************

    public TopVLAN_CVLAN() {

        this.common = new CommonVLAN_CVLAN();
        this.commonBy = new CommonByTCPBytes();

        this.isSingleLine = true;
        this.title = "Top VLAN";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}