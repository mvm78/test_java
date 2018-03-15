package test_java.tiles.common;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTopApplicationsHostPairsAndPorts extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {
            "src dst sport dport app_port",
            "src dst sport dport apptype pcname",
        };
    }

    //**************************************************************************

    @Override
    public String[] getFilters() {

        return new String[] {
            "apptype none",
            "not apptype none"
        };
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Source", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "host {{value}}",
                    "host {{value}}",
                });
            }});
            put("Destination", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "host {{value}}",
                    "host {{value}}",
                });
            }});
            put("Source Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String[] {
                    "port {{value}}",
                    "port {{value}}",
                });
            }});
            put("Destination Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 4);
                put("filter", new String[] {
                    "app_port {{value}}",
                    "app_port {{value}}",
                });
            }});
            put("Application", new ConcurrentHashMap<String, Object>() {{
                put("order", 5);
                put("filter", new String[] {
                    "apptype none and app_port {{value}}",
                    "apptype {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}