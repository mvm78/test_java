package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopResponseCodes;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSResponses extends Table {

    //**************************************************************************

    public TopDNSResponses() {

        final CommonTopResponseCodes CommonInstance = new CommonTopResponseCodes();
        final CommonByNumberOfRecordsAndLatency CommonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top DNS Responses");
        this.setPrefix("DnsAgg");
        this.setCommonData();
    }

    //**************************************************************************

}