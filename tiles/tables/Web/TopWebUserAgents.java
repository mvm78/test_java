package test_java.tiles.tables.Web;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Web.CommonTopWebUserAgents;
import test_java.tiles.common.Web.CommonByNumberOfTransactionsBytesAndTransactionLatency;

public class TopWebUserAgents extends Table {

    //**************************************************************************

    public TopWebUserAgents() {

        final CommonTopWebUserAgents commonInstance = new CommonTopWebUserAgents();
        final CommonByNumberOfTransactionsBytesAndTransactionLatency commonByInstance =
                new CommonByNumberOfTransactionsBytesAndTransactionLatency();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("Top User Agents");
        this.setPrefix("HttpAgg");
    }

    //**************************************************************************

}