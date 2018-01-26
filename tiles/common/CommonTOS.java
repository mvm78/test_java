package test_java.tiles.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTOS extends Common {

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"tos diffserv"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Type of Service", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String [] {
                    "tos {{value}}",
                });
            }});
            put("Differentiated Services", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String [] {
                    "diffserv {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}