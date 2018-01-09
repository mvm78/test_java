package test_java.tiles.tables.DNS;

import test_java.tiles.tables.Table;
import test_java.tiles.common.DNS.CommonTopResponseCodes;
import test_java.tiles.common.DNS.CommonByNumberOfRecordsAndLatency;

public class TopDNSResponses extends Table {

    //**************************************************************************

    public TopDNSResponses() {

        this.common = new CommonTopResponseCodes();
        this.commonBy = new CommonByNumberOfRecordsAndLatency();

        this.title = "Top DNS Responses";
        this.prefix = "DnsAgg";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}