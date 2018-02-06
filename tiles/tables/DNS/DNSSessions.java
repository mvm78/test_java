package test_java.tiles.tables.DNS;

import test_java.tiles.tables.*;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import test_java.tiles.common.Common;

public class DNSSessions extends Table {

    //**************************************************************************

    public DNSSessions() {

        this.setIsSingleLine(true);
        this.setTitle("DNS Sessions");
        this.setPrefix("DnsFlow");
        this.setFields();
        this.setFilters();
        this.setColumns(new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Start Time", new HashMap<String, Object>() {{
                put("order", 0);
                put("startTime", "");
            }});
            put("DNS Type", new HashMap<String, Object>() {{
                put("order", 1);
                put("compare", "true");
            }});
            put("Unknown", new HashMap<String, Object>() {{
                put("order", 2);
            }});
            put("Domain Name", new HashMap<String, Object>() {{
                put("order", 3);
                put("compare", "true");
            }});
            put("Resolved IP", new HashMap<String, Object>() {{
                put("order", 4);
                put("compare", "true");
            }});
            put("Unknown", new HashMap<String, Object>() {{
                put("order", 5);
            }});
            put("Unknown", new HashMap<String, Object>() {{
                put("order", 6);
            }});
            put("DNS Response Code", new HashMap<String, Object>() {{
                put("order", 7);
                put("compare", "true");
            }});
            put("Unknown", new HashMap<String, Object>() {{
                put("order", 8);
            }});
            put("Client", new HashMap<String, Object>() {{
                put("order", 9);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Destination", new HashMap<String, Object>() {{
                put("order", 10);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Client Port", new HashMap<String, Object>() {{
                put("order", 11);
                put("filter", new String [] {
                    "port {{value}}",
                });
            }});
            put("Server Port", new HashMap<String, Object>() {{
                put("order", 12);
                put("filter", new String [] {
                    "app_port {{value}}",
                });
            }});
            put("Unknown", new HashMap<String, Object>() {{
                put("order", 13);
            }});
            put("DNS TTL Mean Value", new HashMap<String, Object>() {{
                put("order", 14);
                put("compare", "number");
            }});
            put("DNS Number of Records", new HashMap<String, Object>() {{
                put("order", 15);
                put("compare", "number");
            }});
            put("Unknown", new HashMap<String, Object>() {{
                put("order", 16);
            }});
            put("RDNS Response Data	", new HashMap<String, Object>() {{
                put("order", 17);
                put("compare", "true");
            }});
            put("Stop Time", new HashMap<String, Object>() {{
                put("order", 18);
                put("stopTime", "+ 1 μs");
            }});
            put("Unknown", new HashMap<String, Object>() {{
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
