package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class Experts extends Report {

    //**************************************************************************

    public Experts() {

        this.setAppPath("/usr/local/mercury/bin/agg-multi");
        this.setTitle("Experts - Network vs Web Application Weight");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("tables", new String[] {
                "Web.WebSessions",
                "Experts.ExpertsTCPSessions",
                "Experts.ExpertsTopTCPServersByBytes",
                "Web.TopWebServers",
            });
        }});
    };

    //**************************************************************************

}