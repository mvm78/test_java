package test_java.reports;

import java.util.*;

public class SIP_KPIs extends Report {

    //**************************************************************************

    public SIP_KPIs() {

        this.setAppPath("/usr/local/niksun/netvoice/bin/queryCdr");
        this.refresh = "";

        this.setTitle("SIP KPIs");
        this.tilesFolder = "SIP_KPIs";

        this.tileList = new HashMap<String, String []>() {{
            put("tables", new String [] {
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
        }};
    };

    //**************************************************************************

}