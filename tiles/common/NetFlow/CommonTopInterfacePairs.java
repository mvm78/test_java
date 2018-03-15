package test_java.tiles.common.NetFlow;

import test_java.tiles.common.*;
import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTopInterfacePairs extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"dlci tchannel device"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Output Interface", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "tchannel {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Device", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "device {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
            put("Input Interface", new ConcurrentHashMap<String, Object>() {{
                put("order", 3);
                put("filter", new String[] {
                    "dlci {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}