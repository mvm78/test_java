package test_java.reports;

import java.util.*;

public class TopApplications extends Report {

    //**************************************************************************

    public TopApplications() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Top Applications";

        this.tileList = new HashMap<String, String []>() {{
            put("charts", new String [] {
                "ThroughputVsGoodput",
            });
            put("tables", new String [] {
                "TopApplicationsByBytesAndPackets",
                "TopTCPApplicationsByBytes",
                "TopApplicationsByResponseTimeAndRetransmittedBytes",
                "TopApplicationsByThroughput",
            });
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

}