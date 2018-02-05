package test_java.tiles.tables;

import test_java.tiles.common.CommonTOS;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopTOSByBytesAndPackets extends Table {

    //**************************************************************************

    public TopTOSByBytesAndPackets() {

        CommonTOS CommonInstance = new CommonTOS();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Top TOS by Bytes and Packets";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}