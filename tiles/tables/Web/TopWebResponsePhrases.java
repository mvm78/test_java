package test_java.tiles.tables.Web;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Web.CommonTopWebResponsePhrases;
import test_java.tiles.common.Web.CommonByNumberOfTransactionsBytesAndTransactionLatency;

public class TopWebResponsePhrases extends Table {

    //**************************************************************************

    public TopWebResponsePhrases() {

        this.common = new CommonTopWebResponsePhrases();
        this.commonBy = new CommonByNumberOfTransactionsBytesAndTransactionLatency();

        this.title = "Top Response Phrases";
        this.prefix = "HttpAgg";
        this.setCommonData();
    }

    //**************************************************************************

}