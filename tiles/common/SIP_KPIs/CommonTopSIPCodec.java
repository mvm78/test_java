package test_java.tiles.common.SIP_KPIs;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopSIPCodec extends CommonSIP {

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Codec", new HashMap<String, Object>() {{
                put("order", 0);
                put("filter", new String [] {
                    "codec \"{{value}}\"",
                });
            }});
        }};
    }

    //**************************************************************************

}