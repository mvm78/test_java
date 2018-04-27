package test_java.tiles.common;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopDevices extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"device"};
    }

    //**************************************************************************

    @Override
    public String[] getFilters() {

        return new String[] {};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, Map<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, Map<String, Object>>() {{
            put("Device", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "device {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}