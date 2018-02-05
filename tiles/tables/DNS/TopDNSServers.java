package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSServers extends Table {

    //**************************************************************************

    public TopDNSServers() {

        this.common = new CommonTopServers();

        CommonByNumberOfRecordsAndLatency CommonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommonBy(CommonByInstance);
        this.title = "Top DNS Servers";
        this.prefix = "DnsAgg";
        this.setCommonData();
    }

    //**************************************************************************

}