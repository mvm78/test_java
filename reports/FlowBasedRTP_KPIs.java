package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class FlowBasedRTP_KPIs extends Report {

    //**************************************************************************

    public FlowBasedRTP_KPIs() {

        this.setAppPath("/usr/local/mercury/bin/agg-netflow");
        this.setTitle("Media Flow");
        this.setTilesFolder("MediaFlow");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("tables", new String[] {
                "MediaFlow",
            });
        }});
    };

    //**************************************************************************

}