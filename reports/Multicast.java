package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class Multicast extends Report {

    //**************************************************************************

    public Multicast() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("Multicast");
        this.setTilesFolder("Multicast");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("tables", new String[] {
                "TopSourcesByBytesAndPackets",
                "TopGroupsByBytesAndPackets",
                "TopTalkerPairsByBytesAndPackets",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("TopTalkerPairsByBytesAndPackets", new String[] {
                "TopSourcesByBytesAndPackets",
                "TopGroupsByBytesAndPackets",
            });
        }});
    };

    //**************************************************************************

}