package test_java.tiles.common.Database;

import test_java.tiles.common.*;
import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTopQueryTypes extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"querytype"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Query Type", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "querytype \"{{value}}\"",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}