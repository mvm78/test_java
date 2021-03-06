package test_java.tiles.common;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopMACAddressPairs extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"macs macd"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("MAC Source", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "macs {{value}}",
                });
            }});
            put("MAC Destination", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "macd {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}