package test_java.tiles.common;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTopTCPApplications extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {
            "apptype pcname",
        };
    }

    //**************************************************************************

    @Override
    public String[] getFilters() {

        return new String[] {
            "not apptype none",
        };
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Application", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "apptype {{value}}",
                });
                put("cellDrill", new String[] {});
            }});
        }};
    }

    //**************************************************************************

}