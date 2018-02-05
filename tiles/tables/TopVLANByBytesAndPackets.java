package test_java.tiles.tables;

import test_java.tiles.common.CommonVLAN_CVLAN;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopVLANByBytesAndPackets extends Table {

    //**************************************************************************

    public TopVLANByBytesAndPackets() {

        CommonVLAN_CVLAN CommonInstance = new CommonVLAN_CVLAN();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top VLAN by Bytes and Packets");
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}