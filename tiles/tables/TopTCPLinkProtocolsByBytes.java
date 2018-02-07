package test_java.tiles.tables;

import test_java.tiles.common.CommonLinkTopProtocols;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPLinkProtocolsByBytes extends Table {

    //**************************************************************************

    public TopTCPLinkProtocolsByBytes() {

        final CommonLinkTopProtocols commonInstance = new CommonLinkTopProtocols();
        final CommonByTCPBytes commonByInstance = new CommonByTCPBytes();

        this.setIsSingleLine(true);
        this.setTitle("Top TCP Link Protocols");
        this.setPrefix("TcpAgg flowsegments");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}