package test_java.tiles.common.Web;

import test_java.tiles.common.*;
import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

public class CommonTopWebResponsePhrases extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"reason method"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("Request Method", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "method {{value}}",
                });
            }});
            put("Response Phrase", new ConcurrentHashMap<String, Object>() {{
                put("order", 2);
                put("filter", new String[] {
                    "reason {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}