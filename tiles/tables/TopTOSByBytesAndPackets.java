package test_java.tiles.tables;

import test_java.tiles.common.CommonTOS;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopTOSByBytesAndPackets extends Table {

    //**************************************************************************

    public TopTOSByBytesAndPackets() {

        final CommonTOS commonInstance = new CommonTOS();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top TOS by Bytes and Packets");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}