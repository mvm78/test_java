package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSServers extends Table {

    //**************************************************************************

    public TopDNSServers() {

        final CommonTopServers commonInstance = new CommonTopServers();
        final CommonByNumberOfRecordsAndLatency commonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setTitle("Top DNS Servers");
        this.setPrefix("DnsAgg");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}