package test_java.reports;

import java.util.*;

public class Experts extends Report {

    //**************************************************************************

    public Experts() {

        this.setAppPath("/usr/local/mercury/bin/agg-multi");

        this.setTitle("Experts - Network vs Web Application Weight");

        this.setTileList(new HashMap<String, String []>() {{
            put("tables", new String [] {
                "Web.WebSessions",
                "Experts.ExpertsTCPSessions",
                "Experts.ExpertsTopTCPServersByBytes",
                "Web.TopWebServers",
            });
        }});
    };

    //**************************************************************************

}