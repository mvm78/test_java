package test_java.tiles.common;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTopCountryPairs extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"src_geo dst_geo"};
    }

    //**************************************************************************

    @Override
    public String[] getFilters() {

        return new String[] {};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Source Country", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "geo {{value}}",
                });
            }});
            put("Destination Country", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "geo {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}