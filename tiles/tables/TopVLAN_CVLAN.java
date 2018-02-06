package test_java.tiles.tables;

import test_java.tiles.common.CommonVLAN_CVLAN;
import test_java.tiles.common.CommonByTCPBytes;

public class TopVLAN_CVLAN extends Table {

    //**************************************************************************

    public TopVLAN_CVLAN() {

        final CommonVLAN_CVLAN commonInstance = new CommonVLAN_CVLAN();
        final CommonByTCPBytes commonByInstance = new CommonByTCPBytes();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top VLAN");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}