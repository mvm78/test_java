package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopRequestTypes;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSRequestTypes extends Table {

    //**************************************************************************

    public TopDNSRequestTypes() {

        CommonTopRequestTypes CommonInstance = new CommonTopRequestTypes();
        CommonByNumberOfRecordsAndLatency CommonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Top DNS Request Types";
        this.prefix = "DnsAgg";
        this.setCommonData();
    }

    //**************************************************************************

}