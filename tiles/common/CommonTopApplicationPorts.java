package test_java.tiles.common;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopApplicationPorts extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"app_port"};
    }

    //**************************************************************************

    @Override
    public String[] getFilters() {

        return new String[] {
            "tcp or udp or sctp",
        };
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("Application Port", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "app_port {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}