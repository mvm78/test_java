package test_java.tiles.common.RTP_KPIs;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.*;

public class CommonTopRTPVLAN extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"vlan"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("VLAN", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "vlan {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}