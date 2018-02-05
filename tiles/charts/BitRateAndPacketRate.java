package test_java.tiles.charts;

import test_java.tiles.common.CommonByBytesAndPackets;

public class BitRateAndPacketRate extends Chart {

    //**************************************************************************

    public BitRateAndPacketRate() {

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.setTitle("Bit Rate and Packet Rate");
        this.prefix = "NetDist";
        this.setCommonByData();
    }

    //**************************************************************************

}