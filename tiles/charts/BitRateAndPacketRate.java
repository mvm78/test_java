package test_java.tiles.charts;

import test_java.tiles.common.CommonByBytesAndPackets;

public class BitRateAndPacketRate extends Chart {

    //**************************************************************************

    public BitRateAndPacketRate() {

        this.commonBy = new CommonByBytesAndPackets();

        this.title = "Bit Rate and Packet Rate";
        this.prefix = "NetDist";
        this.setCommonByData();
    }

    //**************************************************************************

}