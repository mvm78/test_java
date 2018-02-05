package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationsHostPairsAndPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class Flows extends Table {

    //**************************************************************************

    public Flows() {

        this.common = new CommonTopApplicationsHostPairsAndPorts();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Flows";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}