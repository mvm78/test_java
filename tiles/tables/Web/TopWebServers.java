package test_java.tiles.tables.Web;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Web.CommonTopWebServers;
import test_java.tiles.common.Web.CommonByNumberOfTransactionsBytesAndTransactionLatency;

public class TopWebServers extends Table {

    //**************************************************************************

    public TopWebServers() {

        this.common = new CommonTopWebServers();
        this.commonBy = new CommonByNumberOfTransactionsBytesAndTransactionLatency();

        this.title = "Top Web Servers";
        this.prefix = "HttpAgg";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}