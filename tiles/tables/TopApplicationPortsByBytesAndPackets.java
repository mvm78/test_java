package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopApplicationPortsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopApplicationPortsByBytesAndPackets() {

        final CommonTopApplicationPorts CommonInstance = new CommonTopApplicationPorts();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by Bytes and Packets");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}