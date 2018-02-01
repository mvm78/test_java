package test_java.reports;

import java.util.*;

public class FlowBasedRTP_KPIs extends Report {

    //**************************************************************************

    public FlowBasedRTP_KPIs() {

        this.appPath = "/usr/local/mercury/bin/agg-netflow";
        this.refresh = "refreshTO 5.0";

        this.title = "Media Flow";
        this.tilesFolder = "MediaFlow";

        this.tileList = new HashMap<String, String []>() {{
            put("tables", new String [] {
                "MediaFlow",
            });
        }};
    };

    //**************************************************************************

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}