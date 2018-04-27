package test_java.tiles.common.NetFlow;

import test_java.tiles.common.*;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopInputInterfaces extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"dlci device"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("Input Device", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "device {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Input Interface", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "dlci {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}