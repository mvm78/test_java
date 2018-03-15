package test_java.tiles.tables.RTP_KPIs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

import test_java.tiles.tables.*;
import test_java.tiles.common.Common;

public class RTPSessions extends Table {

    //**************************************************************************

    public RTPSessions() {

        this.setTitle("RTP Sessions");
        this.setPrefix("RtpFlow");
        this.setFields(new String[] {
            "plink ptun pmin pmax"
        });
        this.setFilters();
        this.setColumns(new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("First Timestamp", new ConcurrentHashMap<String, Object>() {{
                put("order", 0);
                put("startTime", "");
            }});
            put("Last Timestamp", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("stopTime", "+ 1 μs");
            }});
            put("Source MAC", new ConcurrentHashMap<String, Object>() {{
                put("order", 3);
                put("compare", "true");
            }});
            put("Destination MAC", new ConcurrentHashMap<String, Object>() {{
                put("order", 4);
                put("compare", "true");
            }});
            put("Tunnel Id", new ConcurrentHashMap<String, Object>() {{
                put("order", 13);
                put("cellDrill", new String[] {
                    "teid {{value}}",
                });
                put("compare", "true");
            }});
            put("Source", new ConcurrentHashMap<String, Object>() {{
                put("order", 19);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Destination", new ConcurrentHashMap<String, Object>() {{
                put("order", 20);
                put("filter", new String[] {
                    "host {{value}}",
                });
            }});
            put("Client Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 21);
                put("filter", new String[] {
                    "port {{value}}",
                });
            }});
            put("RTP Destination Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 22);
                put("filter", new String[] {
                    "port {{value}}",
                });
            }});
            put("RTP Synchronization Source", new ConcurrentHashMap<String, Object>() {{
                put("order", 23);
                put("cellDrill", new String[] {
                    "ssrc {{value}}",
                });
                put("compare", "true");
            }});
            put("RTP Payload Type (Codec)", new ConcurrentHashMap<String, Object>() {{
                put("order", 24);
                put("cellDrill", new String[] {
                    "pt \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Packet Count", new ConcurrentHashMap<String, Object>() {{
                put("order", 25);
                put("compare", "true");
            }});
            put("Byte Count", new ConcurrentHashMap<String, Object>() {{
                put("order", 26);
                put("compare", "true");
            }});
            put("Loss Count", new ConcurrentHashMap<String, Object>() {{
                put("order", 35);
                put("compare", "true");
            }});
            put("Packet Loss Percentage", new ConcurrentHashMap<String, Object>() {{
                put("order", 36);
                put("compare", "true");
            }});
            put("Interarrival Time Jitter", new ConcurrentHashMap<String, Object>() {{
                put("order", 37);
                put("compare", "true");
            }});
            put("Average Jitter", new ConcurrentHashMap<String, Object>() {{
                put("order", 38);
                put("compare", "true");
            }});
            put("Minimum Jitter", new ConcurrentHashMap<String, Object>() {{
                put("order", 39);
                put("compare", "true");
            }});
            put("Maximum Jitter", new ConcurrentHashMap<String, Object>() {{
                put("order", 40);
                put("compare", "true");
            }});
            put("Average Delta", new ConcurrentHashMap<String, Object>() {{
                put("order", 41);
                put("compare", "true");
            }});
            put("Minimum Delta", new ConcurrentHashMap<String, Object>() {{
                put("order", 42);
                put("compare", "true");
            }});
            put("Maximum Delta", new ConcurrentHashMap<String, Object>() {{
                put("order", 43);
                put("compare", "true");
            }});
            put("Average Delta", new ConcurrentHashMap<String, Object>() {{
                put("order", 44);
                put("compare", "true");
            }});
            put("MOS Score", new ConcurrentHashMap<String, Object>() {{
                put("order", 47);
                put("compare", "true");
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
