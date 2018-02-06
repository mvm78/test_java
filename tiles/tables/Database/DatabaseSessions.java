package test_java.tiles.tables.Database;

import test_java.tiles.tables.*;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import test_java.tiles.common.Common;

public class DatabaseSessions extends Table {

    //**************************************************************************

    public DatabaseSessions() {

        this.setIsSingleLine(true);
        this.setTitle("Database Sessions");
        this.setPrefix("DbFlow");
        this.setFields();
        this.setFilters();
        this.setColumns(new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Start Time", new HashMap<String, Object>() {{
                put("order", 0);
                put("startTime", "");
            }});
            put("Stop Time", new HashMap<String, Object>() {{
                put("order", 1);
                put("stopTime", "+ 1 μs");
            }});
            put("Source", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Destination", new HashMap<String, Object>() {{
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
            put("Server Port", new HashMap<String, Object>() {{
                put("order", 5);
                put("filter", new String [] {
                    "app_port {{value}}",
                });
            }});
            put("Unknown", new HashMap<String, Object>() {{
                put("order", 6);
            }});
            put("Unknown", new HashMap<String, Object>() {{
                put("order", 7);
            }});
            put("Query Type", new HashMap<String, Object>() {{
                put("order", 8);
                put("cellDrill", new String [] {
                    "querytype \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Query Status", new HashMap<String, Object>() {{
                put("order", 9);
                put("cellDrill", new String [] {
                    "querystatus \"{{value}}\""
                });
                put("compare", "true");
            }});
            put("Query", new HashMap<String, Object>() {{
                put("order", 10);
                put("cellDrill", new String [] {
                    "query \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Latency", new HashMap<String, Object>() {{
                put("order", 11);
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