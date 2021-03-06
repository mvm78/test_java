package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationsHostPairsAndPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class Flows extends Table {

    //**************************************************************************

    public Flows() {

        final CommonTopApplicationsHostPairsAndPorts commonInstance =
                new CommonTopApplicationsHostPairsAndPorts();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setIsSingleLine(true);
        this.setTitle("Flows");
        this.setPrefix("NetDist");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}