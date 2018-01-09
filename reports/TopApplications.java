package test_java.reports;

import java.util.*;

public class TopApplications extends Report {

    //**************************************************************************

    public TopApplications() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Top Applications";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("ThroughputVsGoodput");
            }});
            put("tables", new ArrayList<String>() {{
                add("TopApplicationsByBytesAndPackets");
                add("TopTCPApplicationsByBytes");
                add("TopApplicationsByResponseTimeAndRetransmittedBytes");
                add("TopApplicationsByThroughput");
            }});
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopTCPApplicationsByBytes", new String [] {
                "TopApplicationsByResponseTimeAndRetransmittedBytes",
            });
            put("TopApplicationsByThroughput", new String [] {
                "ThroughputVsGoodput",
            });
        }};
    }

    //**************************************************************************

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}