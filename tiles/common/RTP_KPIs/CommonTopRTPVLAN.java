package test_java.tiles.common.RTP_KPIs;

import java.util.concurrent.ConcurrentHashMap;;
import java.util.LinkedHashMap;

import test_java.tiles.common.*;

public class CommonTopRTPVLAN extends Common {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"vlan"};
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> getFilterColumns() {

        return new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() {{
            put("VLAN", new ConcurrentHashMap<String, Object>() {{
                put("order", 1);
                put("filter", new String[] {
                    "vlan {{value}}",
                });
            }});
        }};
    }

    //**************************************************************************

}