package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplications;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopApplicationsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopApplicationsByBytesAndPackets() {

        final CommonTopApplications CommonInstance = new CommonTopApplications();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Applications by Bytes and Packets");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}