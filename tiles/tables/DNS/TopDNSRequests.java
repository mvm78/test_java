package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopRequests;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSRequests extends Table {

    //**************************************************************************

    public TopDNSRequests() {

        final CommonTopRequests commonInstance = new CommonTopRequests();
        final CommonByNumberOfRecordsAndLatency commonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setTitle("Top DNS Reqests");
        this.setPrefix("DnsAgg");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}