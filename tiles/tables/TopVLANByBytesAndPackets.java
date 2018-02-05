package test_java.tiles.tables;

import test_java.tiles.common.CommonVLAN_CVLAN;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopVLANByBytesAndPackets extends Table {

    //**************************************************************************

    public TopVLANByBytesAndPackets() {

        final CommonVLAN_CVLAN CommonInstance = new CommonVLAN_CVLAN();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top VLAN by Bytes and Packets");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}