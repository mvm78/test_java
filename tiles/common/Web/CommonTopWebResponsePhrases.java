package test_java.tiles.common.Web;

import test_java.tiles.common.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommonTopWebResponsePhrases extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"reason method"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, HashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Request Method", new HashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "method {{value}}",
                });
            }});
            put("Response Phrase", new HashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "reason {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}