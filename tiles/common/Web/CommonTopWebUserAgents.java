package test_java.tiles.common.Web;

import test_java.tiles.common.*;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopWebUserAgents extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"useragent"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("User-Agent", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "useragent {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}