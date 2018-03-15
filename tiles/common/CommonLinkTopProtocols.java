package test_java.tiles.common;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonLinkTopProtocols extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"type"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Ether Type", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "ether proto {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}