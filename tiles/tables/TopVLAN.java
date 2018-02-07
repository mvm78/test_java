package test_java.tiles.tables;

import test_java.tiles.common.CommonVLAN_CVLAN;
import test_java.tiles.common.CommonByTCPBytes;

public class TopVLAN extends Table {

    //**************************************************************************

    public TopVLAN() {

        final CommonVLAN_CVLAN commonInstance = new CommonVLAN_CVLAN();
        final CommonByTCPBytes commonByInstance = new CommonByTCPBytes();

        this.setIsSingleLine(true);
        this.setTitle("Top VLAN");
        this.setPrefix("TcpAgg flowsegments");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}