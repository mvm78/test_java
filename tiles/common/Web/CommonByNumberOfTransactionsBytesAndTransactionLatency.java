package test_java.tiles.common.Web;

import test_java.tiles.common.*;
import java.util.LinkedHashMap;

public class CommonByNumberOfTransactionsBytesAndTransactionLatency extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "mean latency count numtrans count numbytes";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Transaction Latency", "number");
            put("Number Of Transactions", "number");
            put("Number Of Bytes", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String [] getNoTallyColumns() {

        return new String [] {"Transaction Latency"};
    }

    //**************************************************************************

}
