package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopResponseCodes;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSResponses extends Table {

    //**************************************************************************

    public TopDNSResponses() {

        CommonTopResponseCodes CommonInstance = new CommonTopResponseCodes();
        CommonByNumberOfRecordsAndLatency CommonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top DNS Responses");
        this.prefix = "DnsAgg";
        this.setCommonData();
    }

    //**************************************************************************

}