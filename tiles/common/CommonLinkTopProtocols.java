package test_java.tiles.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonLinkTopProtocols extends Common {

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"type"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Ether Type", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String [] {
                    "ether proto {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}