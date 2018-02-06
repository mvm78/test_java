package test_java.reports;

import java.util.*;

public class TopApplications extends Report {

    //**************************************************************************

    public TopApplications() {

        this.setAppPath("/usr/local/mercury/bin/agg");

        this.setTitle("Top Applications");

        this.setTileList(new HashMap<String, String []>() {{
            put("charts", new String [] {
                "ThroughputVsGoodput",
            });
            put("tables", new String [] {
                "TopApplicationsByBytesAndPackets",
                "TopTCPApplicationsByBytes",
                "TopApplicationsByResponseTimeAndRetransmittedBytes",
                "TopApplicationsByThroughput",
            });
        }});

        this.setTallyCheck(new HashMap<String, String []>() {{
            put("TopTCPApplicationsByBytes", new String [] {
                "TopApplicationsByResponseTimeAndRetransmittedBytes",
            });
            put("TopApplicationsByThroughput", new String [] {
                "ThroughputVsGoodput",
            });
        }});
    }

    //**************************************************************************

}