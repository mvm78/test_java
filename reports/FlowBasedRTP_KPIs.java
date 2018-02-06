package test_java.reports;

import java.util.*;

public class FlowBasedRTP_KPIs extends Report {

    //**************************************************************************

    public FlowBasedRTP_KPIs() {

        this.setAppPath("/usr/local/mercury/bin/agg-netflow");

        this.setTitle("Media Flow");
        this.tilesFolder = "MediaFlow";

        this.setTileList(new HashMap<String, String []>() {{
            put("tables", new String [] {
                "MediaFlow",
            });
        }});
    };

    //**************************************************************************

}