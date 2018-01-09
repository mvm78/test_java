package test_java.tiles.common;

import java.util.LinkedHashMap;

public class CommonByDatabaseLatencyAndSessions extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "mean latency count numrec";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Latency", "number");
            put("Sessions", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String [] getNoTallyColumns() {

        return new String [] {
            "Latency",
        };
    }

    //**************************************************************************

}
