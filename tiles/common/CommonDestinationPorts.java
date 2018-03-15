package test_java.tiles.common;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonDestinationPorts extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"dport"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Destination Port", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "dport {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}