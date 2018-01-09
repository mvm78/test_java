package test_java.tiles.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonNetwork extends Common {

    //**************************************************************************

    public CommonNetwork() {

        this.checkNot = false;
    }

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"dst vlan src cvlan proto app_port type tos sport diffserv"};
    }

    //**************************************************************************

    @Override
    public String [] getFilters() {

        return new String [] {};
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
            }});
            put("Source", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String [] {
                    "host {{value}}",
                    "host {{value}}",
                });
            }});
            put("Destination", new HashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String [] {
                    "host {{value}}",
                    "host {{value}}",
                });
            }});
            put("Source Port", new HashMap<String, Object>() {{
                put("order", 4);
                put("filter", new String [] {
                    "port {{value}}",
                    "port {{value}}",
                });
            }});
            put("Destination Port", new HashMap<String, Object>() {{
                put("order", 5);
                put("filter", new String [] {
                    "app_port {{value}}",
                    "app_port {{value}}",
                });
            }});
            put("Type of Service", new HashMap<String, Object>() {{
                put("order", 6);
                put("filter", new String [] {
                    "tos {{value}}",
                });
            }});
            put("Differentiated Services", new HashMap<String, Object>() {{
                put("order", 7);
                put("filter", new String [] {
                    "diffserv {{value}}",
                });
            }});
            put("VLAN", new HashMap<String, Object>() {{
                put("order", 8);
                put("filter", new String [] {
                    "vlan {{value}}",
                });
            }});
            put("EtherType", new HashMap<String, Object>() {{
                put("order", 9);
                put("filter", new String [] {
                    "type {{value}}",
                });
            }});
            put("Inner VLAN", new HashMap<String, Object>() {{
                put("order", 10);
                put("filter", new String [] {
                    "cvlan {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}