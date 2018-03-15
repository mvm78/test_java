package test_java.tiles.common;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTCPSessions extends Common {

    //**************************************************************************

    public CommonTCPSessions() {

        this.setWindow("0.0 | /usr/local/niksun/apps/bin/extURL -b");
        this.setPrefix("TcpFlow pcname FirstNBytes 256 tcpflags");
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
            put("Client", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Client Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String[] {
                    "port {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Client Bytes", new ConcurrentHashMap<String, Object>() {{
                put("order", 5);
                put("compare", "number");
            }});
            put("Server", new ConcurrentHashMap<String, Object>() {{
                put("order", 6);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Server Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 7);
                put("filter", new String[] {
                    "app_port {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Server Bytes", new ConcurrentHashMap<String, Object>() {{
                put("order", 9);
                put("compare", "number");
            }});
            put("TCP Network Time", new ConcurrentHashMap<String, Object>() {{
                put("order", 11);
                put("compare", "number");
            }});
            put("TCP Response Time", new ConcurrentHashMap<String, Object>() {{
                put("order", 12);
                put("compare", "number");
            }});
            put("Retransmitted Bytes", new ConcurrentHashMap<String, Object>() {{
                put("order", 13);
                put("compare", "number");
            }});
            put("TCP Flags", new ConcurrentHashMap<String, Object>() {{
                put("order", 15);
                put("compare", "true");
            }});
            put("Application Subtype", new ConcurrentHashMap<String, Object>() {{
                put("order", 16);
            }});
            put("URL", new ConcurrentHashMap<String, Object>() {{
                put("order", 17);
                put("compare", "true");
            }});
        }};
    }

    //**************************************************************************

}