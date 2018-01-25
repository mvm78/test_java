package test_java.tiles.tables;

import test_java.tiles.common.CommonTOS;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopTOSByBytesAndPackets extends Table {

    //**************************************************************************

    public TopTOSByBytesAndPackets() {

        this.common = new CommonTOS();
        this.commonBy = new CommonByBytesAndPackets();

        this.isSingleLine = true;
        this.title = "Top TOS by Bytes and Packets";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}