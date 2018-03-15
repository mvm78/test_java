package test_java.tiles.common.Web;

import test_java.tiles.common.*;
import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTopWebUserAgents extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"useragent"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("User-Agent", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "useragent {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}