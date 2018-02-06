package test_java.tiles.charts.DNS;

import test_java.tiles.charts.*;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class DNSRateAndLatency extends Chart {

    //**************************************************************************

    public DNSRateAndLatency() {

        final CommonByNumberOfRecordsAndLatency commonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommonBy(commonByInstance);
        this.setTitle("DNS Rate and Latency");
        this.setPrefix("DnsAgg");
        this.setCommonByData();
    }

    //**************************************************************************

}