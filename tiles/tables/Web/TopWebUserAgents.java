package test_java.tiles.tables.Web;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Web.CommonTopWebUserAgents;
import test_java.tiles.common.Web.CommonByNumberOfTransactionsBytesAndTransactionLatency;

public class TopWebUserAgents extends Table {

    //**************************************************************************

    public TopWebUserAgents() {

        this.common = new CommonTopWebUserAgents();
        this.commonBy = new CommonByNumberOfTransactionsBytesAndTransactionLatency();

        this.title = "Top User Agents";
        this.prefix = "HttpAgg";
        this.setCommonData();
    }

    //**************************************************************************

}