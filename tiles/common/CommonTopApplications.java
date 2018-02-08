package test_java.tiles.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopApplications extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {
            "app_port",
            "apptype pcname",
        };
    }

    //**************************************************************************

    @Override
    public String[] getFilters() {

        return new String[] {
            "apptype none",
            "not apptype none",
        };
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Application", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "apptype none and app_port {{value}}",
                    "apptype {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}