package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopRequestTypes;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSRequestTypes extends Table {

    //**************************************************************************

    public TopDNSRequestTypes() {

        final CommonTopRequestTypes commonInstance = new CommonTopRequestTypes();
        final CommonByNumberOfRecordsAndLatency commonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("Top DNS Request Types");
        this.setPrefix("DnsAgg");
        this.setCommonData();
    }

    //**************************************************************************

}