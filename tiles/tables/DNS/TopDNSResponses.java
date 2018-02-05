package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopResponseCodes;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSResponses extends Table {

    //**************************************************************************

    public TopDNSResponses() {

        this.common = new CommonTopResponseCodes();

        CommonByNumberOfRecordsAndLatency CommonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommonBy(CommonByInstance);
        this.title = "Top DNS Responses";
        this.prefix = "DnsAgg";
        this.setCommonData();
    }

    //**************************************************************************

}