package test_java.tiles.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonNetwork extends Common {

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"dst vlan src cvlan proto app_port type tos sport diffserv"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Protocol", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String [] {
                    "proto {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
            put("Source", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Destination", new HashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Source Port", new HashMap<String, Object>() {{
                put("order", 4);
                put("filter", new String [] {
                    "port {{value}}",
                });
            }});
            put("Destination Port", new HashMap<String, Object>() {{
                put("order", 5);
                put("filter", new String [] {
                    "app_port {{value}}",
                });
            }});
            put("Type of Service", new HashMap<String, Object>() {{
                put("order", 6);
                put("filter", new String [] {
                    "tos {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
            put("Differentiated Services", new HashMap<String, Object>() {{
                put("order", 7);
                put("filter", new String [] {
                    "diffserv {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
            put("VLAN", new HashMap<String, Object>() {{
                put("order", 8);
                put("filter", new String [] {
                    "vlan {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
            put("EtherType", new HashMap<String, Object>() {{
                put("order", 9);
                put("filter", new String [] {
                    "type {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
            put("Inner VLAN", new HashMap<String, Object>() {{
                put("order", 10);
                put("filter", new String [] {
                    "cvlan {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
        }};
    }

    //**************************************************************************

}