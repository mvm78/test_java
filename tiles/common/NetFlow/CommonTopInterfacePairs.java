package test_java.tiles.common.NetFlow;

import test_java.tiles.common.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopInterfacePairs extends Common {

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"dlci tchannel device"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Output Interface", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String [] {
                    "tchannel {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
            put("Device", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String [] {
                    "device {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
            put("Input Interface", new HashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String [] {
                    "dlci {{value}}",
                });
                put("cellDrill", new String [] {});
            }});
        }};
    }

    //**************************************************************************

}