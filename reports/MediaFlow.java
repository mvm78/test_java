package test_java.reports;

import java.util.*;

public class MediaFlow extends Report {

    //**************************************************************************

    public MediaFlow() {

        this.appPath = "/usr/local/mercury/bin/agg-netflow";
        this.refresh = "refreshTO 5.0";

        this.title = "Media Flow";
        this.tilesFolder = "MediaFlow";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
//            put("charts", new ArrayList<String>() {{
//                add("SNMPVariablesChart");
//            }});
            put("tables", new ArrayList<String>() {{
//                add("MediaFlow");
                add("MediaFlowTopSources");
            }});
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
//            put("SNMPTopDeviceInterface", new String [] {
//                "SNMPVariables",
//                "SNMPVariablesChart",
//            });
        }};
    };

    //**************************************************************************

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}