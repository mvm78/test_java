package test_java.tiles.common.Multicast;

import test_java.tiles.common.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopTalkerPairs extends Common {

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"dst src"};
    }

    //**************************************************************************

    @Override
    public String [] getFilters() {

        return new String [] {"ip multicast"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Destination", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
            put("Source", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}