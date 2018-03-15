package test_java.tiles.tables.SIP_KPIs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

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
        this.setColumns(new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Initiation Time", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("startTime", "");
                put("filter", new String[] {});
            }});
            put("End Time", new ConcurrentHashMap<String, Object>() {{
                put("order", 7);
                put("concat", 8);
                put("stopTime", "+ 1 μs");
            }});
            put("VLAN", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("cellDrill", new String[] {
                    "vlan {{value}}",
                });
            }});
            put("Call Ref", new ConcurrentHashMap<String, Object>() {{
                put("order", 11);
                put("compare", "true");
            }});
            put("Reason Header", new ConcurrentHashMap<String, Object>() {{
                put("order", 12);
                put("compare", "true");
            }});
            put("Calling Party Number", new ConcurrentHashMap<String, Object>() {{
                put("order", 13);
                put("cellDrill", new String[] {
                    "calling_num == \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Called Party Number", new ConcurrentHashMap<String, Object>() {{
                put("order", 14);
                put("cellDrill", new String[] {
                    "called_num == \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Source", new ConcurrentHashMap<String, Object>() {{
                put("order", 15);
                put("cellDrill", new String[] {
                    "host {{value}}",
                });
                put("compare", "true");
            }});
            put("Client Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 16);
                put("cellDrill", new String[] {
                    "port {{value}}",
                });
                put("compare", "true");
            }});
            put("Destination", new ConcurrentHashMap<String, Object>() {{
                put("order", 17);
                put("cellDrill", new String[] {
                    "host {{value}}",
                });
                put("compare", "true");
            }});
            put("Client Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 18);
                put("cellDrill", new String[] {
                    "app_port {{value}}",
                });
                put("compare", "true");
            }});
            put("Post Dial Delay", new ConcurrentHashMap<String, Object>() {{
                put("order", 20);
                put("compare", "true");
            }});
            put("Connection Type", new ConcurrentHashMap<String, Object>() {{
                put("order", 21); // may need to swap with Reason Header
                put("cellDrill", new String[] {
                    "connectionType == \"{{value}}\"",
                });
                put("compare", "true");
                put("valueFunction", "getBase64");
            }});
            put("Reason Header", new ConcurrentHashMap<String, Object>() {{
                put("order", 22); // may need to swap with Connection Type
                put("compare", "true");
            }});
            put("Release Cause Code", new ConcurrentHashMap<String, Object>() {{
                put("order", 23);
                put("cellDrill", new String[] {
                    "rcode \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Calling Party User Agent", new ConcurrentHashMap<String, Object>() {{
                put("order", 30);
                put("cellDrill", new String[] {
                    "callingPartyProductName == \"{{value}}\"",
                });
                put("compare", "true");
            }});
            put("Called Party User Agent", new ConcurrentHashMap<String, Object>() {{
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

        int cellDrill = (int)data.get("cellDrill");

        if (cellDrill > 0) {

            data.put("columns", this.getColumns());

            return Common.getRowFilter(data);
        }

        String[] split = (String[])data.get("split");
        byte blocksStart = 49;
        byte blockLength = 43;

        int blocksLength = split.length - blocksStart;

        if (blocksLength % blockLength != 0) {
            return "";
        }

        // split[11] - Call Ref
        String result = "call_ref \"" + split[11] + "\"";

        int blockAmount = blocksLength / blockLength;

        for (int count=0; count<blockAmount; count++) {

            int blockStart = blocksStart + blockLength * count;

            int portIndex = blockStart; // port - 1-st value in a block of values
            int hostIndex = blockStart + 4; // host - 5-th value in a block of values

            result += " or (host " + split[hostIndex] + " and port " + split[portIndex] + ")";
        }

        return result;
    }

    //**************************************************************************

}