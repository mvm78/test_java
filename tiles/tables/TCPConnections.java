package test_java.tiles.tables;

import java.util.HashMap;
import java.util.LinkedHashMap;
import test_java.tiles.common.Common;

public class TCPConnections extends Table {

    //**************************************************************************

    public TCPConnections() {

        this.isSingleLine = true;
        this.title = "IP Conversations";
        this.window = "0.0 | /usr/local/niksun/apps/bin/extURL -b";
        this.prefix = "TcpFlow FirstNBytes 256";
        this.fields = new String [] {
            "tcpflags pcid"
        };
        this.filters = new String [] {};
        this.columns = new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Start Time", new HashMap<String, Object>() {{
                put("order", 1);
                put("startTime", "");
            }});
            put("Stop Time", new HashMap<String, Object>() {{
                put("order", 2);
                put("stopTime", "+ 1 μs");
            }});
            put("Client", new HashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Client Port", new HashMap<String, Object>() {{
                put("order", 4);
                put("filter", new String [] {
                    "port {{value}}",
                });
            }});
            put("Client Bytes", new HashMap<String, Object>() {{
                put("order", 6);
                put("compare", "number");
            }});
            put("Server", new HashMap<String, Object>() {{
                put("order", 7);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Server Port", new HashMap<String, Object>() {{
                put("order", 8);
                put("filter", new String [] {
                    "app_port {{value}}",
                });
            }});
            put("Server Bytes", new HashMap<String, Object>() {{
                put("order", 10);
                put("compare", "number");
            }});
            put("TCP Network Time", new HashMap<String, Object>() {{
                put("order", 12);
                put("compare", "number");
            }});
            put("TCP Response Time", new HashMap<String, Object>() {{
                put("order", 13);
                put("compare", "number");
            }});
            put("Retransmitted Bytes", new HashMap<String, Object>() {{
                put("order", 14);
                put("compare", "number");
            }});
            put("TCP Flags", new HashMap<String, Object>() {{
                put("order", 16);
                put("compare", "true");
            }});
            put("URL", new HashMap<String, Object>() {{
                put("order", 18);
                put("compare", "true");
            }});
        }};
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(HashMap<String, Object> data) {

        data.put("columns", this.columns);

        return Common.getRowFilter(data);
    }

    //**************************************************************************

}
