package test_java.tiles.tables;

import test_java.tiles.common.CommonVLAN_CVLAN;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopVLANByBytesAndPackets extends Table {

    //**************************************************************************

    public TopVLANByBytesAndPackets() {

        this.common = new CommonVLAN_CVLAN();
        this.commonBy = new CommonByBytesAndPackets();

        this.isSingleLine = true;
        this.title = "Top VLAN by Bytes and Packets";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}