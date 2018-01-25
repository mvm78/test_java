package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplications;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopApplicationsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopApplicationsByBytesAndPackets() {

        this.common = new CommonTopApplications();
        this.commonBy = new CommonByBytesAndPackets();

        this.isSingleLine = true;
        this.title = "Top Applications by Bytes and Packets";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}