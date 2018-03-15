package test_java.tiles.common;

import java.util.concurrent.ConcurrentHashMap;;
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
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Application Port", new ConcurrentHashMap<String, Object>() {{
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