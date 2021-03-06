package test_java.tiles.charts.AnomalousTCPSessions;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.charts.*;
import test_java.tiles.common.CommonTCPSessions;

public class AnomalousTCPSessionsTrend extends Chart {

    //**************************************************************************

    public AnomalousTCPSessionsTrend() {

        final CommonTCPSessions commonInstance = new CommonTCPSessions();

        this.setCommon(commonInstance);
        this.setIsSingleLine(true);

        final String instancePrefix = this.getCommon().getPrefix();
        final String[] instanceFilters = this.getCommon().getFilters();

        this.setPrefix(instancePrefix);
        this.setFields();
        this.setFilters(instanceFilters);
        this.setColumns(new LinkedHashMap<String, Map<String, Object>>() {{
            put("Connections", new HashMap<String, Object>() {{
                put("order", 1);
                put("tally", "true");
                put("compare", "true");
            }});
        }});
    }

    //**************************************************************************

}

