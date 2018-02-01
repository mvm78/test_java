package test_java.reports;

import java.util.*;

public class Multicast extends Report {

    //**************************************************************************

    public Multicast() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "Multicast";
        this.tilesFolder = "Multicast";

        this.tileList = new HashMap<String, String []>() {{
            put("tables", new String [] {
                "TopSourcesByBytesAndPackets",
                "TopGroupsByBytesAndPackets",
                "TopTalkerPairsByBytesAndPackets",
            });
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopTalkerPairsByBytesAndPackets", new String [] {
                "TopSourcesByBytesAndPackets",
                "TopGroupsByBytesAndPackets",
            });
        }};
    };

    //**************************************************************************

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}