package test_java.tiles.tables;

import test_java.tiles.common.CommonTopProtocols;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopProtocolsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopProtocolsByBytesAndPackets() {

        this.common = new CommonTopProtocols();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Top Protocols by Bytes and Packets";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}