package test_java.tiles.charts.AnomalousTCPSessions;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.charts.*;
import test_java.tiles.common.CommonTCPSessions;

public class AnomalousTCPSessionsTrend extends Chart {

    //**************************************************************************

    public AnomalousTCPSessionsTrend() {

        CommonTCPSessions CommonInstance = new CommonTCPSessions();

        this.setCommon(CommonInstance);
        this.setIsSingleLine(true);
        this.prefix = this.getCommon().getPrefix();
        this.fields = new String [] {""};
        this.filters = this.getCommon().getFilters();
        this.columns = new LinkedHashMap<String, HashMap<String, Object>>() {{
            put("Connections", new HashMap<String, Object>() {{
                put("order", 1);
                put("tally", "true");
                put("compare", "true");
            }});
        }};
    }

    //**************************************************************************

}

