package test_java.tiles.common.DNS;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

import test_java.tiles.common.*;

public class CommonTopRequestTypes extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"type"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("DNS Type", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "dns.type \"{{value}}\"",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}