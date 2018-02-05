package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplications;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopApplicationsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopApplicationsByBytesAndPackets() {

        CommonTopApplications CommonInstance = new CommonTopApplications();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Top Applications by Bytes and Packets";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}