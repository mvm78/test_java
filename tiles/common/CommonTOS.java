package test_java.tiles.common;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTOS extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"tos diffserv"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Type of Service", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "tos {{value}}",
                });
            }});
            put("Differentiated Services", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "diffserv {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}