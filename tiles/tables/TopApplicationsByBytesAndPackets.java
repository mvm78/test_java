package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplications;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopApplicationsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopApplicationsByBytesAndPackets() {

        final CommonTopApplications commonInstance = new CommonTopApplications();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommonData(commonInstance, commonByInstance);

        this.setIsSingleLine(true);
        this.setTitle("Top Applications by Bytes and Packets");
        this.setPrefix("NetDist");
    }

    //**************************************************************************

}