package test_java.tiles.common.DNS;

import test_java.tiles.common.*;
import java.util.LinkedHashMap;

public class CommonByNumberOfRecordsAndLatency extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "count numrr mean latency";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("DNS Number of Records", "number");
            put("DNS Latency", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String[] getNoTallyColumns() {

        return new String[] {"DNS Latency"};
    }

    //**************************************************************************

}
