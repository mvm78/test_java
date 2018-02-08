package test_java.reports;

import java.util.*;

public class Multicast extends Report {

    //**************************************************************************

    public Multicast() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("Multicast");
        this.setTilesFolder("Multicast");

        this.setTileList(new HashMap<String, String[]>() {{
            put("tables", new String[] {
                "TopSourcesByBytesAndPackets",
                "TopGroupsByBytesAndPackets",
                "TopTalkerPairsByBytesAndPackets",
            });
        }});

        this.setTallyCheck(new HashMap<String, String[]>() {{
            put("TopTalkerPairsByBytesAndPackets", new String[] {
                "TopSourcesByBytesAndPackets",
                "TopGroupsByBytesAndPackets",
            });
        }});
    };

    //**************************************************************************

}