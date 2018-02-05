package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSServers extends Table {

    //**************************************************************************

    public TopDNSServers() {

        final CommonTopServers CommonInstance = new CommonTopServers();
        final CommonByNumberOfRecordsAndLatency CommonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top DNS Servers");
        this.setPrefix("DnsAgg");
        this.setCommonData();
    }

    //**************************************************************************

}