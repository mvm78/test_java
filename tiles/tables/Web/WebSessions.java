package test_java.tiles.tables.Web;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.tables.*;
import test_java.tiles.common.Common;

public class WebSessions extends Table {

    //**************************************************************************

    public WebSessions() {

        this.setAppPath("/usr/local/mercury/bin/agg-http");
        this.setIsSingleLine(true);
        this.setTitle("Web Sessions");
        this.setPrefix("HttpFlow");
        this.setFields();
        this.setFilters();
        this.setColumns(new LinkedHashMap<String, Map<String, Object>>() {{
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
                put("cellDrill", new String[] {
                    "method \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Response Phrase", new HashMap<String, Object>() {{
                put("order", 3);
                put("cellDrill", new String[] {
                    "reason {{value}}",
                });
                put("compare", "true");
            }});
            put("Status Code", new HashMap<String, Object>() {{
                put("order", 4);
                put("cellDrill", new String[] {
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
                put("cellDrill", new String[] {
                    "version {{value}}",
                });
                put("compare", "true");
            }});
            put("Host", new HashMap<String, Object>() {{
                put("order", 7);
                put("cellDrill", new String[] {
                    "hosthttp \"{{value}}\"",
                });
            }});
            put("Request URI", new HashMap<String, Object>() {{
                put("order", 8);
                put("cellDrill", new String[] {
                    "urihttp {{value}}",
                });
            }});
            put("Referer", new HashMap<String, Object>() {{
                put("order", 9);
                put("cellDrill", new String[] {
                    "referer {{value}}",
                });
            }});
            put("User-Agent", new HashMap<String, Object>() {{
                put("order", 10);
                put("cellDrill", new String[] {
                    "useragent {{value}}",
                });
            }});
            put("X-Forwarded-For", new HashMap<String, Object>() {{
                put("order", 11);
                put("cellDrill", new String[] {
                    "xff \"{{value}}\"",
                });
            }});
            put("Source", new HashMap<String, Object>() {{
                put("order", 12);
                put("filter", new String[] {
                    "host {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Destination", new HashMap<String, Object>() {{
                put("order", 13);
                put("filter", new String[] {
                    "host {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Client Port", new HashMap<String, Object>() {{
                put("order", 14);
                put("filter", new String[] {
                    "port {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Server Port", new HashMap<String, Object>() {{
                put("order", 15);
                put("filter", new String[] {
                    "app_port {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Protocol", new HashMap<String, Object>() {{
                put("order", 16);
                put("compare", "true");
            }});
            put("VLAN", new HashMap<String, Object>() {{
                put("order", 17);
                put("cellDrill", new String[] {
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
        }});
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(Map<String, Object> data) {

        data.put("columns", this.getColumns());

        return Common.getRowFilter(data);
    }

    //**************************************************************************

}
