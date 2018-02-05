package test_java.tiles.tables;

import test_java.tiles.common.CommonTopMACAddressPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopMACAddressPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopMACAddressPairsByBytesAndPackets() {

        CommonTopMACAddressPairs CommonInstance = new CommonTopMACAddressPairs();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top MAC Address Pairs by Packets and Bytes");
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}