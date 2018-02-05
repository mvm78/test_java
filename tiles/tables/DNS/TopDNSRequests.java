package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopRequests;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSRequests extends Table {

    //**************************************************************************

    public TopDNSRequests() {

        this.common = new CommonTopRequests();

        CommonByNumberOfRecordsAndLatency CommonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommonBy(CommonByInstance);
        this.title = "Top DNS Reqests";
        this.prefix = "DnsAgg";
        this.setCommonData();
    }

    //**************************************************************************

}