package test_java.tiles.tables;

import test_java.tiles.common.CommonTopApplicationsHostPairsAndPorts;
import test_java.tiles.common.CommonByBytesAndPackets;

public class Flows extends Table {

    //**************************************************************************

    public Flows() {

        final CommonTopApplicationsHostPairsAndPorts CommonInstance =
                new CommonTopApplicationsHostPairsAndPorts();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Flows");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}