package test_java.tiles.common.SIP_KPIs;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopSIPStatusCodes extends CommonSIP {

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("SIP Status Code", new HashMap<String, Object>() {{
                put("order", 0);
                put("filter", new String [] {
                    "error_code == \"{{value}}\"",
                });
            }});
        }};
    }

    //**************************************************************************

}