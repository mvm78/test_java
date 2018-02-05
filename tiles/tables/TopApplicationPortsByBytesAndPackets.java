package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopApplicationPortsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopApplicationPortsByBytesAndPackets() {

        CommonTopApplicationPorts CommonInstance = new CommonTopApplicationPorts();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Top Application Ports by Bytes and Packets";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}