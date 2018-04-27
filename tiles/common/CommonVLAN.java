package test_java.tiles.common;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonVLAN extends Common {

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