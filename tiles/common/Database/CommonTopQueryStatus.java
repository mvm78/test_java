package test_java.tiles.common.Database;

import test_java.tiles.common.*;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopQueryStatus extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"querystatus"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("Query Status", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "querystatus \"{{value}}\"",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}