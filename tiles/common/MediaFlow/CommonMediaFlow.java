package test_java.tiles.common.MediaFlow;

import test_java.tiles.common.*;
import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonMediaFlow extends Common {

    //**************************************************************************

    public CommonMediaFlow() {

        this.setPrefix("MediaFlow");
    }

    //**************************************************************************

    @Override
    public String[] getFields() {

        return new String[] {""};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Start Time", new ConcurrentHashMap<String, Object>() {{
                put("order", 0);
                put("startTime", "");
            }});
            put("Stop Time", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("stopTime", "+ 1 μs");
            }});
            put("Protocol", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("cellDrill", new String[] {
                    "proto {{value}}",
                });
            }});
            put("Source", new ConcurrentHashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Destination", new ConcurrentHashMap<String, Object>() {{
                put("order", 4);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Client Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 5);
                put("filter", new String[] {
                    "port {{value}}",
                });
            }});
            put("Server Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 6);
                put("filter", new String[] {
                    "app_port {{value}}",
                });
            }});
            put("T Channel", new ConcurrentHashMap<String, Object>() {{
                put("order", 8);
                put("cellDrill", new String[] {
                    "tchannel {{value}}",
                });
            }});
            put("Device", new ConcurrentHashMap<String, Object>() {{
                put("order", 9);
                put("cellDrill", new String[] {
                    "device {{value}}",
                });
            }});
            put("Data link connection identifier", new ConcurrentHashMap<String, Object>() {{
                put("order", 10);
                put("cellDrill", new String[] {
                    "dlci {{value}}",
                });
            }});
            put("EtherType", new ConcurrentHashMap<String, Object>() {{
                put("order", 12);
                put("cellDrill", new String[] {
                    "ether proto {{value}}",
                });
            }});
            put("Ingress VLAN", new ConcurrentHashMap<String, Object>() {{
                put("order", 13);
                put("cellDrill", new String[] {
                    "srcvlan {{value}}",
                });
            }});
            put("Engress VLAN", new ConcurrentHashMap<String, Object>() {{
                put("order", 14);
                put("cellDrill", new String[] {
                    "dstvlan {{value}}",
                });
            }});
            put("Synchronization Source", new ConcurrentHashMap<String, Object>() {{
                put("order", 15);
                put("cellDrill", new String[] {
                    "ssrc {{value}}",
                });
            }});
            put("Codec", new ConcurrentHashMap<String, Object>() {{
                put("order", 16);
                put("cellDrill", new String[] {
                    "codec {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}