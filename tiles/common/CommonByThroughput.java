package test_java.tiles.common;

import java.util.LinkedHashMap;

public class CommonByThroughput extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "count goodput count thruput";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Goodput", "number");
            put("Throughput", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String [] getNoTallyColumns() {

        return new String [] {};
    }

    //**************************************************************************

}