package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopRequests;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSRequests extends Table {

    //**************************************************************************

    public TopDNSRequests() {

        final CommonTopRequests CommonInstance = new CommonTopRequests();
        final CommonByNumberOfRecordsAndLatency CommonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top DNS Reqests");
        this.setPrefix("DnsAgg");
        this.setCommonData();
    }

    //**************************************************************************

}