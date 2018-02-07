package test_java.tiles.tables;

import test_java.tiles.common.CommonTopMACAddressPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopMACAddressPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopMACAddressPairsByBytesAndPackets() {

        final CommonTopMACAddressPairs commonInstance = new CommonTopMACAddressPairs();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setTitle("Top MAC Address Pairs by Packets and Bytes");
        this.setPrefix("NetDist");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}