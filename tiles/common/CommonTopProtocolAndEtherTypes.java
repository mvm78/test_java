package test_java.tiles.common;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopProtocolAndEtherTypes extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"proto type"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("Protocol", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "proto {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Ether Type", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "type {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}