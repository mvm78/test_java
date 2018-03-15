package test_java.tiles.common.SIP_KPIs;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

import test_java.tiles.common.Common;

public class CommonTopSIPConnectionTypes extends Common {

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Connection Type", new ConcurrentHashMap<String, Object>() {{
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