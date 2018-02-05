package test_java.tiles.tables.Web;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Web.CommonTopWebServers;
import test_java.tiles.common.Web.CommonByNumberOfTransactionsBytesAndTransactionLatency;

public class TopWebServers extends Table {

    //**************************************************************************

    public TopWebServers() {

        final CommonTopWebServers CommonInstance = new CommonTopWebServers();
        final CommonByNumberOfTransactionsBytesAndTransactionLatency CommonByInstance =
                new CommonByNumberOfTransactionsBytesAndTransactionLatency();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top Web Servers");
        this.setAppPath("/usr/local/mercury/bin/agg-http");
        this.setPrefix("HttpAgg");
        this.setCommonData();
    }

    //**************************************************************************

}