package test_java.tiles.tables;

import test_java.tiles.common.CommonTopMACAddressPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopMACAddressPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopMACAddressPairsByBytesAndPackets() {

        this.common = new CommonTopMACAddressPairs();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.title = "Top MAC Address Pairs by Packets and Bytes";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}