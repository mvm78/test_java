package test_java.tiles.tables.DNS;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;;

import test_java.tiles.tables.*;
import test_java.tiles.common.Common;

public class DNSSessions extends Table {

    //**************************************************************************

    public DNSSessions() {

        this.setIsSingleLine(true);
        this.setTitle("DNS Sessions");
        this.setPrefix("DnsFlow");
        this.setFields();
        this.setFilters();
        this.setColumns(new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Start Time", new ConcurrentHashMap<String, Object>() {{
                put("order", 0);
                put("startTime", "");
            }});
            put("DNS Type", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("compare", "true");
            }});
            put("Unknown", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
            }});
            put("Domain Name", new ConcurrentHashMap<String, Object>() {{
                put("order", 3);
                put("compare", "true");
            }});
            put("Resolved IP", new ConcurrentHashMap<String, Object>() {{
                put("order", 4);
                put("compare", "true");
            }});
            put("Unknown", new ConcurrentHashMap<String, Object>() {{
                put("order", 5);
            }});
            put("Unknown", new ConcurrentHashMap<String, Object>() {{
                put("order", 6);
            }});
            put("DNS Response Code", new ConcurrentHashMap<String, Object>() {{
                put("order", 7);
                put("compare", "true");
            }});
            put("Unknown", new ConcurrentHashMap<String, Object>() {{
                put("order", 8);
            }});
            put("Client", new ConcurrentHashMap<String, Object>() {{
                put("order", 9);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Destination", new ConcurrentHashMap<String, Object>() {{
                put("order", 10);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Client Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 11);
                put("filter", new String[] {
                    "port {{value}}",
                });
            }});
            put("Server Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 12);
                put("filter", new String[] {
                    "app_port {{value}}",
                });
            }});
            put("Unknown", new ConcurrentHashMap<String, Object>() {{
                put("order", 13);
            }});
            put("DNS TTL Mean Value", new ConcurrentHashMap<String, Object>() {{
                put("order", 14);
                put("compare", "number");
            }});
            put("DNS Number of Records", new ConcurrentHashMap<String, Object>() {{
                put("order", 15);
                put("compare", "number");
            }});
            put("Unknown", new ConcurrentHashMap<String, Object>() {{
                put("order", 16);
            }});
            put("RDNS Response Data	", new ConcurrentHashMap<String, Object>() {{
                put("order", 17);
                put("compare", "true");
            }});
            put("Stop Time", new ConcurrentHashMap<String, Object>() {{
                put("order", 18);
                put("stopTime", "+ 1 μs");
            }});
            put("Unknown", new ConcurrentHashMap<String, Object>() {{
                put("order", 19);
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
