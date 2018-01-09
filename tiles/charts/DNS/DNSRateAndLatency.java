package test_java.tiles.charts.DNS;

import test_java.tiles.charts.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class DNSRateAndLatency extends Chart {

    //**************************************************************************

    public DNSRateAndLatency() {

        this.commonBy = new CommonByNumberOfRecordsAndLatency();

        this.title = "DNS Rate and Latency";
        this.prefix = "DnsAgg";
        this.fields = new String [] {
            this.commonBy.getFields(),
        };
        this.filters = new String [] {};
        this.columns = this.commonBy.appendCompareColumns(
                new LinkedHashMap<String, HashMap<String, Object>>() {}, 1
        );
    }

    //**************************************************************************

}