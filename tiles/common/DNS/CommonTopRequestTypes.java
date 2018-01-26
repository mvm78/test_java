package test_java.tiles.common.DNS;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.*;

public class CommonTopRequestTypes extends Common {

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"type"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("DNS Type", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String [] {
                    "dns.type \"{{value}}\"",
                });
                put("cellDrill", new String [] {});
            }});
        }};
    }

    //**************************************************************************

}