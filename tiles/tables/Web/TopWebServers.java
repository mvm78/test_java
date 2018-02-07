package test_java.tiles.tables.Web;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Web.CommonTopWebServers;
import test_java.tiles.common.Web.CommonByNumberOfTransactionsBytesAndTransactionLatency;

public class TopWebServers extends Table {

    //**************************************************************************

    public TopWebServers() {

        final CommonTopWebServers commonInstance = new CommonTopWebServers();
        final CommonByNumberOfTransactionsBytesAndTransactionLatency commonByInstance =
                new CommonByNumberOfTransactionsBytesAndTransactionLatency();

        this.setTitle("Top Web Servers");
        this.setAppPath("/usr/local/mercury/bin/agg-http");
        this.setPrefix("HttpAgg");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}