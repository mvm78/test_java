package test_java.tiles.tables;

import test_java.tiles.common.CommonTopTCPApplicationPorts;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPApplicationPortsByBytes extends Table {

    //**************************************************************************

    public TopTCPApplicationPortsByBytes() {

        final CommonTopTCPApplicationPorts commonInstance =
                new CommonTopTCPApplicationPorts();
        final CommonByTCPBytes commonByInstance = new CommonByTCPBytes();

        this.setIsSingleLine(true);
        this.setTitle("Top TCP Application Ports by Bytes");
        this.setPrefix("TcpAgg flowsegments");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}