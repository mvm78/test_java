package test_java.tiles.common.DNS;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.*;

public class CommonTopRequests extends Common {

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"type name addr rcode dst rdata"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("DNS Type", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String [] {
                    "dns.type \"{{value}}\"",
                });
                put("cellDrill", new String [] {});
            }});
            put("Domain Name", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String [] {
                    "dns.name \"{{value}}\"",
                });
                put("cellDrill", new String [] {});
            }});
            put("Resolved IP", new HashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String [] {
                    "dns.addr \"{{value}}\"",
                });
                put("cellDrill", new String [] {});
            }});
            put("DNS Response Code", new HashMap<String, Object>() {{
                put("order", 4);
                put("filter", new String [] {
                    "dns.rcode \"{{value}}\"",
                });
                put("cellDrill", new String [] {});
            }});
            put("Destination", new HashMap<String, Object>() {{
                put("order", 5);
                put("filter", new String [] {
                    "host \"{{value}}\"",
                });
            }});
            put("DNS Response Data", new HashMap<String, Object>() {{
                put("order", 6);
                put("filter", new String [] {
                    "dns.rdata \"{{value}}\"",
                });
                put("cellDrill", new String [] {});
            }});
        }};
    }

    //**************************************************************************

}