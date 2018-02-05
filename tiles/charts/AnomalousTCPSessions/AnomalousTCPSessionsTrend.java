package test_java.tiles.charts.AnomalousTCPSessions;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.charts.*;
import test_java.tiles.common.CommonTCPSessions;

public class AnomalousTCPSessionsTrend extends Chart {

    //**************************************************************************

    public AnomalousTCPSessionsTrend() {

        final CommonTCPSessions CommonInstance = new CommonTCPSessions();

        this.setCommon(CommonInstance);
        this.setIsSingleLine(true);

        final String instancePrefix = this.getCommon().getPrefix();

        this.setPrefix(instancePrefix);
        this.setFields();
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

