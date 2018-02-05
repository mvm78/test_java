package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTopProtocolAndEtherTypes;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowTopProtocolAndEtherTypesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowTopProtocolAndEtherTypesByBytesAndPackets() {

        this.common = new CommonTopProtocolAndEtherTypes();

        CommonByBytesAndPackets CommonByInstance = new CommonByBytesAndPackets();

        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.title = "Network - Top Protocol and EtherType by Packets and Bytes";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}