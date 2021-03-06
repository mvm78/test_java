package test_java.tiles.tables.SIP_KPIs;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicReference;

import test_java.tiles.tables.*;
import test_java.tiles.common.Common;

public class SIPSessions extends Table {

    //**************************************************************************

    public SIPSessions() {

        this.setIsSingleLine(true);
        this.setTitle("Web Sessions");
        this.setPrefix("list 999");
        this.setFields();
        this.setFilters();
        this.setSplitChar(",");
        this.setColumns(new LinkedHashMap<String, Map<String, Object>>() {{
            put("Initiation Time", new HashMap<String, Object>() {{
                put("order", 1);
                put("startTime", "");
                put("filter", new String[] {});
            }});
            put("End Time", new HashMap<String, Object>() {{
                put("order", 7);
                put("concat", 8);
                put("stopTime", "+ 1 μs");
            }});
            put("VLAN", new HashMap<String, Object>() {{
                put("order", 2);
                put("cellDrill", new String[] {
                    "vlan {{value}}",
                });
            }});
            put("Call Ref", new HashMap<String, Object>() {{
                put("order", 11);
                put("compare", "true");
            }});
            put("Reason Header", new HashMap<String, Object>() {{
                put("order", 12);
                put("compare", "true");
            }});
            put("Calling Party Number", new HashMap<String, Object>() {{
                put("order", 13);
                put("cellDrill", new String[] {
                    "calling_num == \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Called Party Number", new HashMap<String, Object>() {{
                put("order", 14);
                put("cellDrill", new String[] {
                    "called_num == \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Source", new HashMap<String, Object>() {{
                put("order", 15);
                put("cellDrill", new String[] {
                    "host {{value}}",
                });
                put("compare", "true");
            }});
            put("Client Port", new HashMap<String, Object>() {{
                put("order", 16);
                put("cellDrill", new String[] {
                    "port {{value}}",
                });
                put("compare", "true");
            }});
            put("Destination", new HashMap<String, Object>() {{
                put("order", 17);
                put("cellDrill", new String[] {
                    "host {{value}}",
                });
                put("compare", "true");
            }});
            put("Client Port", new HashMap<String, Object>() {{
                put("order", 18);
                put("cellDrill", new String[] {
                    "app_port {{value}}",
                });
                put("compare", "true");
            }});
            put("Post Dial Delay", new HashMap<String, Object>() {{
                put("order", 20);
                put("compare", "true");
            }});
            put("Connection Type", new HashMap<String, Object>() {{
                put("order", 21); // may need to swap with Reason Header
                put("cellDrill", new String[] {
                    "connectionType == \"{{value}}\"",
                });
                put("compare", "true");
                put("valueFunction", "getBase64");
            }});
            put("Reason Header", new HashMap<String, Object>() {{
                put("order", 22); // may need to swap with Connection Type
                put("compare", "true");
            }});
            put("Release Cause Code", new HashMap<String, Object>() {{
                put("order", 23);
                put("cellDrill", new String[] {
                    "rcode \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Calling Party User Agent", new HashMap<String, Object>() {{
                put("order", 30);
                put("cellDrill", new String[] {
                    "callingPartyProductName == \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Called Party User Agent", new HashMap<String, Object>() {{
                put("order", 32);
                put("cellDrill", new String[] {
                    "calledPartyProductName == \"{{value}}\"",
                });
                put("compare", "true");
            }});
        }});
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(Map<String, Object> data) {

        final int cellDrill = (int)data.get("cellDrill");

        if (cellDrill > 0) {

            data.put("columns", this.getColumns());

            return Common.getRowFilter(data);
        }

        final String[] split = (String[])data.get("split");
        final byte blocksStart = 49;
        final byte blockLength = 43;

        final int blocksLength = split.length - blocksStart;

        if (blocksLength % blockLength != 0) {
            return "";
        }
        // split[11] - Call Ref
        final AtomicReference<String> result =
                new AtomicReference<>("call_ref \"" + split[11] + "\"");

        IntStream.range(0, blocksLength / blockLength).parallel()
                .forEach(count -> {

                    int blockStart = blocksStart + blockLength * count;

                    final String host = split[blockStart + 4]; // host - 5-th value in a block of values
                    final String port = split[blockStart]; // port - 1-st value in a block of values

                    result.set(result.get() + " or (host " + host + " and port " + port + ")");
                });

        return result.get();
    }

    //**************************************************************************

}