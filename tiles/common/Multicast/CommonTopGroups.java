package test_java.tiles.common.Multicast;

import test_java.tiles.common.*;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopGroups extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"dst"};
    }

    //**************************************************************************

    @Override
    public String[] getFilters() {

        return new String[] {"ip multicast"};
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
        }};
    }

    //**************************************************************************

}