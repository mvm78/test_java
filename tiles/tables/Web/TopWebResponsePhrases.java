package test_java.tiles.tables.Web;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Web.CommonTopWebResponsePhrases;
import test_java.tiles.common.Web.CommonByNumberOfTransactionsBytesAndTransactionLatency;

public class TopWebResponsePhrases extends Table {

    //**************************************************************************

    public TopWebResponsePhrases() {

        final CommonTopWebResponsePhrases commonInstance = new CommonTopWebResponsePhrases();
        final CommonByNumberOfTransactionsBytesAndTransactionLatency commonByInstance =
                new CommonByNumberOfTransactionsBytesAndTransactionLatency();

        this.setTitle("Top Response Phrases");
        this.setPrefix("HttpAgg");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}