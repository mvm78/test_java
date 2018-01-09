package test_java.tiles.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopSources extends Common {

    //**************************************************************************

    public CommonTopSources() {

        this.checkNot = false;
    }

    //**************************************************************************

    @Override
    public String [] getFields(){

        return new String [] {"src"};
    }

    //**************************************************************************

    @Override
    public String [] getFilters() {

        return new String [] {};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Source", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String [] {
                    "host {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}