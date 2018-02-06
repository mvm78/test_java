package test_java.tiles.tables.NetFlow;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTopProtocolAndEtherTypes;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetFlowTopProtocolAndEtherTypesByBytesAndPackets extends Table {

    //**************************************************************************

    public NetFlowTopProtocolAndEtherTypesByBytesAndPackets() {

        final CommonTopProtocolAndEtherTypes commonInstance =
                new CommonTopProtocolAndEtherTypes();
        final CommonByBytesAndPackets commonByInstance = new CommonByBytesAndPackets();

        this.setCommonData(commonInstance, commonByInstance);

        this.setIsSingleLine(true);
        this.setTitle("Network - Top Protocol and EtherType by Packets and Bytes");
        this.setPrefix("NetDist");
    }

    //**************************************************************************

}