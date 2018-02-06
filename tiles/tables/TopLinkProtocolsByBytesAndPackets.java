package test_java.tiles.tables;

import test_java.tiles.common.CommonLinkTopProtocols;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopLinkProtocolsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopLinkProtocolsByBytesAndPackets() {

        final CommonLinkTopProtocols commonInstance = new CommonLinkTopProtocols();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommonData(commonInstance, commonByInstance);

        this.setIsSingleLine(true);
        this.setTitle("Top Link Protocols by Bytes and Packets");
        this.setPrefix("NetDist");
    }

    //**************************************************************************

}