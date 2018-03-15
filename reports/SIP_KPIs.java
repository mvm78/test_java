package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class SIP_KPIs extends Report {

    //**************************************************************************

    public SIP_KPIs() {

        this.setAppPath("/usr/local/niksun/netvoice/bin/queryCdr");
        this.setRefresh("");
        this.setTitle("SIP KPIs");
        this.setTilesFolder("SIP_KPIs");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("tables", new String[] {
                "TopSIPStatusCodes",
                "TopSIPCallingNumbers",
                "TopSIPCallingIP",
                "TopSIPCalledNumbers",
                "TopSIPCalledIP",
                "TopSIPVLAN",
                "TopSIPConnectionTypes",
                "TopSIPCallingUserAgents",
                "TopSIPCalledUserAgents",
                "TopSIPCodec",
                "SIPSessions",
            });
        }});
    };

    //**************************************************************************

}