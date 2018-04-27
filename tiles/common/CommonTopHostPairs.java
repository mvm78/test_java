package test_java.tiles.common;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopHostPairs extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"dst src"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("Destination", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Source", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}