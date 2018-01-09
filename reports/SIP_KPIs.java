package test_java.reports;

import java.util.*;

public class SIP_KPIs extends Report {

    //**************************************************************************

    public SIP_KPIs() {

        this.appPath = "/usr/local/niksun/netvoice/bin/queryCdr";
        this.refresh = "";

        this.title = "SIP KPIs";
        this.tilesFolder = "SIP_KPIs";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("tables", new ArrayList<String>() {{
                add("TopSIPStatusCodes");
                add("TopSIPCallingNumbers");
                add("TopSIPCallingIP");
                add("TopSIPCalledNumbers");
                add("TopSIPCalledIP");
                add("TopSIPVLAN");
                add("TopSIPConnectionTypes");
                add("TopSIPCallingUserAgents");
                add("TopSIPCalledUserAgents");
                add("TopSIPCodec");
                add("SIPSessions");
            }});
        }};
    };

    //**************************************************************************

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}