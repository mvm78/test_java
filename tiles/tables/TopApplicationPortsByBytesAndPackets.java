package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopApplicationPortsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopApplicationPortsByBytesAndPackets() {

        final CommonTopApplicationPorts commonInstance = new CommonTopApplicationPorts();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Application Ports by Bytes and Packets");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}