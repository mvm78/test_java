package test_java.reports;

import java.util.*;

public class DNSPerformance extends Report {

    //**************************************************************************

    public DNSPerformance() {

        this.appPath = "/usr/local/mercury/bin/agg-dns R";
        this.refresh = "refreshTO 5.0";

        this.title = "DNS Performance";
        this.tilesFolder = "DNS";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("DNSRateAndLatency");
            }});
            put("tables", new ArrayList<String>() {{
                add("TopDNSRequestTypes");
                add("TopDNSResponses");
                add("TopDNSServers");
                add("TopDNSRequests");
                add("DNSSessions");
            }});
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("TopDNSRequestTypes", new String [] {
                "DNSRateAndLatency",
                "TopDNSResponses",
                "TopDNSServers",
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