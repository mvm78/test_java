package test_java.tiles.common.SIP_KPIs;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.Common;

public class CommonTopSIPConnectionTypes extends Common {

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("Connection Type", new HashMap<String, Object>() {{
                put("order", 0);
                put("filter", new String[] {
                    "connectionType == \"{{value}}\"",
                });
                put("valueFunction", "getBase64");
            }});
        }};
    }

    //**************************************************************************

}