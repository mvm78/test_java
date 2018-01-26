package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTopProtocolAndEtherTypes;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowTopProtocolAndEtherTypesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowTopProtocolAndEtherTypesByBytesAndPackets() {

        this.common = new CommonTopProtocolAndEtherTypes();
        this.commonBy = new CommonByBytesAndPackets();

        this.isSingleLine = true;
        this.title = "Network - Top Protocol and EtherType by Packets and Bytes";
        this.prefix = "NetDist";
        this.setCommonData();
    }

    //**************************************************************************

}