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
        this.appPath = "/usr/local/mercury/bin/agg-http";
        this.prefix = "HttpAgg";
        this.setCommonData();
    }

    //**************************************************************************

}