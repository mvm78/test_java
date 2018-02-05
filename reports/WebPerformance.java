package test_java.reports;

import java.util.*;

public class WebPerformance extends Report {

    //**************************************************************************

    public WebPerformance() {

        this.setAppPath("/usr/local/mercury/bin/agg-http");
        this.refresh = "refreshTO 5.0";

        this.setTitle("Web Performance");
        this.tilesFolder = "Web";

        this.tileList = new HashMap<String, String []>() {{
            put("tables", new String [] {
                "TopWebServers",
                "TopWebResponsePhrases",
                "TopWebUserAgents",
                "WebSessions",
            });
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopWebServers", new String [] {
                "TopWebResponsePhrases",
                "TopWebUserAgents",
            });
        }};
    };

    //**************************************************************************

}