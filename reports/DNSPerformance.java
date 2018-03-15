package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class DNSPerformance extends Report {

    //**************************************************************************

    public DNSPerformance() {

        this.setAppPath("/usr/local/mercury/bin/agg-dns R");
        this.setTitle("DNS Performance");
        this.setTilesFolder("DNS");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("charts", new String[] {
                "DNSRateAndLatency",
            });
            put("tables", new String[] {
                "TopDNSRequestTypes",
                "TopDNSResponses",
                "TopDNSServers",
                "TopDNSRequests",
                "DNSSessions",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("TopDNSRequestTypes", new String[] {
                "DNSRateAndLatency",
                "TopDNSResponses",
                "TopDNSServers",
            });
        }});
    };

    //**************************************************************************

}