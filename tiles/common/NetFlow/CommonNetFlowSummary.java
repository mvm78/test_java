package test_java.tiles.common.NetFlow;

import test_java.tiles.common.*;
import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonNetFlowSummary extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"dlci dst app_port src dstvlan tchannel device srcvlan"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Source", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Destination", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Application Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String[] {
                    "app_port {{value}}",
                });
            }});
            put("Output Interface", new ConcurrentHashMap<String, Object>() {{
                put("order", 4);
                put("filter", new String[] {
                    "tchannel {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Device", new ConcurrentHashMap<String, Object>() {{
                put("order", 5);
                put("filter", new String[] {
                    "device {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Input Interface", new ConcurrentHashMap<String, Object>() {{
                put("order", 6);
                put("filter", new String[] {
                    "dlci {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Ingress VLAN", new ConcurrentHashMap<String, Object>() {{
                put("order", 7);
                put("filter", new String[] {
                    "srcvlan {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Engress VLAN", new ConcurrentHashMap<String, Object>() {{
                put("order", 8);
                put("filter", new String[] {
                    "dstvlan {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}