package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopResponseCodes;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSResponses extends Table {

    //**************************************************************************

    public TopDNSResponses() {

        final CommonTopResponseCodes commonInstance = new CommonTopResponseCodes();
        final CommonByNumberOfRecordsAndLatency commonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("Top DNS Responses");
        this.setPrefix("DnsAgg");
        this.setCommonData();
    }

    //**************************************************************************

}