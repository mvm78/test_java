package test_java.reports;

import java.util.*;

public class RTP_KPIs extends Report {

    //**************************************************************************

    public RTP_KPIs() {

        this.appPath = "/usr/local/mercury/bin/agg-rtp";
        this.refresh = "refreshTO 5.0";

        this.title = "RTP KPIs";
        this.tilesFolder = "RTP_KPIs";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("RTPPacketsSessionsAndLoss");
            }});
            put("tables", new ArrayList<String>() {{
                add("TopRTPCodec");
                add("TopRTPSources");
                add("TopRTPDestinations");
                add("TopRTPVLAN");
                add("RTPSessions");
            }});
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("RTPPacketsSessionsAndLoss", new String [] {
                "TopRTPCodec",
                "TopRTPSources",
                "TopRTPDestinations",
                "TopRTPVLAN",
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