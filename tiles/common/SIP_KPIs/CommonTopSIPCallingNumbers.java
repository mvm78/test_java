package test_java.tiles.common.SIP_KPIs;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.Common;

public class CommonTopSIPCallingNumbers extends Common {

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Calling Party Number", new HashMap<String, Object>() {{
                put("order", 0);
                put("filter", new String [] {
                    "calling_num == \"{{value}}\"",
                });
            }});
        }};
    }

    //**************************************************************************

}