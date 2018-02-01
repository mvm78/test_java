package test_java.reports;

import java.util.*;

public class DNSPerformance extends Report {

    //**************************************************************************

    public DNSPerformance() {

        this.appPath = "/usr/local/mercury/bin/agg-dns R";
        this.refresh = "refreshTO 5.0";

        this.title = "DNS Performance";
        this.tilesFolder = "DNS";

        this.tileList = new HashMap<String, String []>() {{
            put("charts", new String [] {
                "DNSRateAndLatency",
            });
            put("tables", new String [] {
                "TopDNSRequestTypes",
                "TopDNSResponses",
                "TopDNSServers",
                "TopDNSRequests",
                "DNSSessions",
            });
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