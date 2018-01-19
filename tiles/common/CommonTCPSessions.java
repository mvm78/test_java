package test_java.tiles.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTCPSessions extends Common {

    //**************************************************************************

    public CommonTCPSessions() {

        this.window = "0.0 | /usr/local/niksun/apps/bin/extURL -b";
        this.prefix = "TcpFlow pcname FirstNBytes 256 tcpflags";
    }

    //**************************************************************************

    @Override
    public String [] getFields() {

        return new String [] {""};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Start Time", new HashMap<String, Object>() {{
                put("order", 0);
                put("startTime", "");
            }});
            put("Stop Time", new HashMap<String, Object>() {{
                put("order", 1);
                put("stopTime", "+ 1 μs");
            }});
            put("Client", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Client Port", new HashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String [] {
                    "port {{value}}",
                });
            }});
            put("Client Bytes", new HashMap<String, Object>() {{
                put("order", 5);
                put("compare", "number");
            }});
            put("Server", new HashMap<String, Object>() {{
                put("order", 6);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Server Port", new HashMap<String, Object>() {{
                put("order", 7);
                put("filter", new String [] {
                    "app_port {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
            put("Server Bytes", new HashMap<String, Object>() {{
                put("order", 9);
                put("compare", "number");
            }});
            put("TCP Network Time", new HashMap<String, Object>() {{
                put("order", 11);
                put("compare", "number");
            }});
            put("TCP Response Time", new HashMap<String, Object>() {{
                put("order", 12);
                put("compare", "number");
            }});
            put("Retransmitted Bytes", new HashMap<String, Object>() {{
                put("order", 13);
                put("compare", "number");
            }});
            put("TCP Flags", new HashMap<String, Object>() {{
                put("order", 15);
                put("compare", "true");
            }});
            put("Application Subtype", new HashMap<String, Object>() {{
                put("order", 16);
            }});
            put("URL", new HashMap<String, Object>() {{
                put("order", 17);
                put("compare", "true");
            }});
        }};
    }

    //**************************************************************************

}