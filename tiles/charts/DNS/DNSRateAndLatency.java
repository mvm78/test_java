package test_java.tiles.charts.DNS;

import test_java.tiles.charts.*;

import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class DNSRateAndLatency extends Chart {

    //**************************************************************************

    public DNSRateAndLatency() {

        CommonByNumberOfRecordsAndLatency CommonByInstance =
                new CommonByNumberOfRecordsAndLatency();

        this.setCommonBy(CommonByInstance);
        this.title = "DNS Rate and Latency";
        this.prefix = "DnsAgg";
        this.setCommonByData();
    }

    //**************************************************************************

}