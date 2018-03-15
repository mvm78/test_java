package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class RTP_KPIs extends Report {

    //**************************************************************************

    public RTP_KPIs() {

        this.setAppPath("/usr/local/mercury/bin/agg-rtp");
        this.setTitle("RTP KPIs");
        this.setTilesFolder("RTP_KPIs");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("charts", new String[] {
                "RTPPacketsSessionsAndLoss",
            });
            put("tables", new String[] {
                "TopRTPCodec",
                "TopRTPSources",
                "TopRTPDestinations",
                "TopRTPVLAN",
                "RTPSessions",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("RTPPacketsSessionsAndLoss", new String[] {
                "TopRTPCodec",
                "TopRTPSources",
                "TopRTPDestinations",
                "TopRTPVLAN",
            });
        }});
   };

    //**************************************************************************

}