package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class WebPerformance extends Report {

    //**************************************************************************

    public WebPerformance() {

        this.setAppPath("/usr/local/mercury/bin/agg-http");

        this.setTitle("Web Performance");
        this.setTilesFolder("Web");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("tables", new String[] {
                "TopWebServers",
                "TopWebResponsePhrases",
                "TopWebUserAgents",
                "WebSessions",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("TopWebServers", new String[] {
                "TopWebResponsePhrases",
                "TopWebUserAgents",
            });
        }});
    };

    //**************************************************************************

}