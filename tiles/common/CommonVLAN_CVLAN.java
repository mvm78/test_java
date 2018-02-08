package test_java.tiles.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonVLAN_CVLAN extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"vlan cvlan"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("VLAN", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "vlan {{value}}",
                });
            }});
            put("Inner VLAN", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "cvlan {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}