package test_java.tiles.tables;

import test_java.tiles.common.CommonTOS;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopTOSByBytesAndPackets extends Table {

    //**************************************************************************

    public TopTOSByBytesAndPackets() {

        final CommonTOS CommonInstance = new CommonTOS();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top TOS by Bytes and Packets");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}