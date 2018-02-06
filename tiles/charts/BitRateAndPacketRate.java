package test_java.tiles.charts;

import test_java.tiles.common.CommonByBytesAndPackets;

public class BitRateAndPacketRate extends Chart {

    //**************************************************************************

    public BitRateAndPacketRate() {

        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(commonByInstance);
        this.setTitle("Bit Rate and Packet Rate");
        this.setPrefix("NetDist");
        this.setCommonByData();
    }

    //**************************************************************************

}