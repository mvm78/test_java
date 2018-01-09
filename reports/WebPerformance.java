package test_java.reports;

import java.util.*;

public class WebPerformance extends Report {

    //**************************************************************************

    public WebPerformance() {

        this.appPath = "/usr/local/mercury/bin/agg-http";
        this.refresh = "refreshTO 5.0";

        this.title = "Web Performance";
        this.tilesFolder = "Web";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("tables", new ArrayList<String>() {{
                add("TopWebServers");
                add("TopWebResponsePhrases");
                add("TopWebUserAgents");
                add("WebSessions");
            }});
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopWebServers", new String [] {
                "TopWebResponsePhrases",
                "TopWebUserAgents",
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