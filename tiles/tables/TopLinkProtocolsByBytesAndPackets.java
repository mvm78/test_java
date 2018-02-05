package test_java.tiles.tables;

import test_java.tiles.common.CommonLinkTopProtocols;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopLinkProtocolsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopLinkProtocolsByBytesAndPackets() {

        CommonLinkTopProtocols CommonInstance = new CommonLinkTopProtocols();
        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Link Protocols by Bytes and Packets");
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}