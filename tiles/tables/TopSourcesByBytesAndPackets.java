package test_java.tiles.tables;

import test_java.tiles.common.CommonTopSources;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopSourcesByBytesAndPackets extends Table {

    //**************************************************************************

    public TopSourcesByBytesAndPackets() {

        this.common = new CommonTopSources();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.title = "Top Sources by Bytes and Packets";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}