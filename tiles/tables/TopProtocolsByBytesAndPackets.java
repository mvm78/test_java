package test_java.tiles.tables;

import test_java.tiles.common.CommonTopProtocols;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopProtocolsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopProtocolsByBytesAndPackets() {

        final CommonTopProtocols commonInstance = new CommonTopProtocols();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommonData(commonInstance, commonByInstance);

        this.setIsSingleLine(true);
        this.setTitle("Top Protocols by Bytes and Packets");
        this.setPrefix("NetDist");
    }

    //**************************************************************************

}