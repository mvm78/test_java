package test_java.tiles.common;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTopMACAddressPairs extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"macs macd"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("MAC Source", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "macs {{value}}",
                });
            }});
            put("MAC Destination", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "macd {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}