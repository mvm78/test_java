package test_java.tiles.common.DNS;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.*;

public class CommonTopResponseCodes extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"rcode"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("DNS Response Code", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "dns.rcode \"{{value}}\"",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}