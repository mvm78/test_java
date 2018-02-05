package test_java.tiles.tables;

import test_java.tiles.common.CommonTopProtocols;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopProtocolsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopProtocolsByBytesAndPackets() {

        final CommonTopProtocols CommonInstance = new CommonTopProtocols();
        final CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Protocols by Bytes and Packets");
        this.setPrefix("NetDist");
        this.setCommonData();
    }

    //**************************************************************************

}