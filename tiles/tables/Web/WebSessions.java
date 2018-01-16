package test_java.tiles.tables.Web;

import test_java.tiles.tables.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import test_java.tiles.common.Common;

public class WebSessions extends Table {

    //**************************************************************************

    public WebSessions() {

        this.isSingleLine = true;
        this.title = "Web Sessions";
        this.window = "0.0";
        this.prefix = "HttpFlow";
        this.fields = new String [] {""};
        this.filters = new String [] {};
        this.columns = new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Start Time", new HashMap<String, Object>() {{
                put("order", 0);
                put("startTime", "");
            }});
            put("Stop Time", new HashMap<String, Object>() {{
                put("order", 1);
                put("stopTime", "+ 1 μs");
            }});
            put("Request Method", new HashMap<String, Object>() {{
                put("order", 2);
                put("cellDrill", new String [] {
                    "method \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Response Phrase", new HashMap<String, Object>() {{
                put("order", 3);
                put("cellDrill", new String [] {
                    "reason \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Status Code", new HashMap<String, Object>() {{
                put("order", 4);
                put("cellDrill", new String [] {
                    "statusnum {{value}}",
                });
                put("compare", "true");
            }});
            put("Transaction Status", new HashMap<String, Object>() {{
                put("order", 5);
                put("compare", "true");
            }});
            put("Request Version", new HashMap<String, Object>() {{
                put("order", 6);
                put("cellDrill", new String [] {
                    "version {{value}}",
                });
                put("compare", "true");
            }});
            put("Host", new HashMap<String, Object>() {{
                put("order", 7);
                put("cellDrill", new String [] {
                    "hosthttp \"{{value}}\"",
                });
            }});
            put("Request URI", new HashMap<String, Object>() {{
                put("order", 8);
                put("cellDrill", new String [] {
                    "urihttp \"{{value}}\"",
                });
            }});
            put("Referer", new HashMap<String, Object>() {{
                put("order", 9);
                put("cellDrill", new String [] {
                    "referer \"{{value}}\"",
                });
            }});
            put("User-Agent", new HashMap<String, Object>() {{
                put("order", 10);
                put("cellDrill", new String [] {
                    "useragent \"{{value}}\"",
                });
            }});
            put("X-Forwarded-For", new HashMap<String, Object>() {{
                put("order", 11);
                put("cellDrill", new String [] {
                    "xff \"{{value}}\"",
                });
            }});
            put("Source", new HashMap<String, Object>() {{
                put("order", 12);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Destination", new HashMap<String, Object>() {{
                put("order", 13);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Client Port", new HashMap<String, Object>() {{
                put("order", 14);
                put("filter", new String [] {
                    "port {{value}}",
                });
            }});
            put("Server Port", new HashMap<String, Object>() {{
                put("order", 15);
                put("filter", new String [] {
                    "app_port {{value}}",
                });
            }});
            put("Protocol", new HashMap<String, Object>() {{
                put("order", 16);
                put("compare", "true");
            }});
            put("VLAN", new HashMap<String, Object>() {{
                put("order", 17);
                put("cellDrill", new String [] {
                    "vlan {{value}}",
                });
            }});
            put("Number Of Bytes", new HashMap<String, Object>() {{
                put("order", 18);
                put("compare", "number");
            }});
            put("Number of Packets", new HashMap<String, Object>() {{
                put("order", 19);
                put("compare", "number");
            }});
            put("Transaction Latency", new HashMap<String, Object>() {{
                put("order", 20);
                put("compare", "number");
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
