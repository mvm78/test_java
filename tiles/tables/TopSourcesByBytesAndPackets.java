package test_java.tiles.tables;

import test_java.tiles.common.CommonTopSources;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopSourcesByBytesAndPackets extends Table {

    //**************************************************************************

    public TopSourcesByBytesAndPackets() {

        final CommonTopSources CommonInstance = new CommonTopSources();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top Sources by Bytes and Packets");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}