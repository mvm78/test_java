package test_java.tiles.tables;

import test_java.tiles.common.CommonVLAN_CVLAN;
import test_java.tiles.common.CommonByTCPBytes;

public class TopVLAN extends Table {

    //**************************************************************************

    public TopVLAN() {

        this.common = new CommonVLAN_CVLAN();
        this.commonBy = new CommonByTCPBytes();

        this.setIsSingleLine(true);
        this.title = "Top VLAN";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}