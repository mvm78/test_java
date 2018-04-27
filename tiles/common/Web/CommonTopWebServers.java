package test_java.tiles.common.Web;

import test_java.tiles.common.*;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopWebServers extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"hosthttp dst"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("Host", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "hosthttp \"{{value}}\"",
                });
            }});
            put("Destination", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}