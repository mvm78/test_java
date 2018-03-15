package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class TopApplications extends Report {

    //**************************************************************************

    public TopApplications() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("Top Applications");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("charts", new String[] {
                "ThroughputVsGoodput",
            });
            put("tables", new String[] {
                "TopApplicationsByBytesAndPackets",
                "TopTCPApplicationsByBytes",
                "TopApplicationsByResponseTimeAndRetransmittedBytes",
                "TopApplicationsByThroughput",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("TopTCPApplicationsByBytes", new String[] {
                "TopApplicationsByResponseTimeAndRetransmittedBytes",
            });
            put("TopApplicationsByThroughput", new String[] {
                "ThroughputVsGoodput",
            });
        }});
    }

    //**************************************************************************

}