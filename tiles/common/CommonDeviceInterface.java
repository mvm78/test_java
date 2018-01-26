package test_java.tiles.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonDeviceInterface extends Common {

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"src sport"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Source", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String [] {
                    "src {{value}}",
                });
            }});
            put("Source Port", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String [] {
                    "sport {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}