package test_java.tiles.tables;

import test_java.tiles.common.CommonLinkTopProtocols;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPLinkProtocolsByBytes extends Table {

    //**************************************************************************

    public TopTCPLinkProtocolsByBytes() {

        this.common = new CommonLinkTopProtocols();
        this.commonBy = new CommonByTCPBytes();

        this.setIsSingleLine(true);
        this.title = "Top TCP Link Protocols";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}