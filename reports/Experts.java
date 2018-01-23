package test_java.reports;

import java.util.*;

public class Experts extends Report {

    //**************************************************************************

    public Experts() {

        this.appPath = "/usr/local/mercury/bin/agg-multi";
        this.refresh = "refreshTO 5.0";

        this.title = "Experts - Network vs Web Application Weight";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("tables", new ArrayList<String>() {{
                add("Web.WebSessions");
                add("Experts.TCPSessions");
            }});
        }};
    };

    //**************************************************************************

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}