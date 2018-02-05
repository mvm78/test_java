package test_java.tiles.tables.Web;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Web.CommonTopWebUserAgents;
import test_java.tiles.common.Web.CommonByNumberOfTransactionsBytesAndTransactionLatency;

public class TopWebUserAgents extends Table {

    //**************************************************************************

    public TopWebUserAgents() {

        CommonTopWebUserAgents CommonInstance = new CommonTopWebUserAgents();
        CommonByNumberOfTransactionsBytesAndTransactionLatency CommonByInstance =
                new CommonByNumberOfTransactionsBytesAndTransactionLatency();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Top User Agents");
        this.prefix = "HttpAgg";
        this.setCommonData();
    }

    //**************************************************************************

}