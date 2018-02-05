package test_java.tiles.tables;

import test_java.tiles.common.CommonLinkTopProtocols;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopLinkProtocolsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopLinkProtocolsByBytesAndPackets() {

        this.common = new CommonLinkTopProtocols();
        this.commonBy = new CommonByBytesAndPackets();

        this.setIsSingleLine(true);
        this.title = "Top Link Protocols by Bytes and Packets";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}