package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class DatabasePerformance extends Report {

    //**************************************************************************

    public DatabasePerformance() {

        this.setAppPath("/usr/local/mercury/bin/agg-db");
        this.setTitle("Database Performance");
        this.setTilesFolder("Database");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("charts", new String[] {
                "DatabaseLatencyAndRecordsOverTime",
            });
            put("tables", new String[] {
                "DatabaseTopQueryTypes",
                "DatabaseTopQueryStatus",
                "DatabaseTopServers",
                "DatabaseTopHostPairs",
                "DatabaseTypes",
                "DatabaseTopVLAN",
                "DatabaseSessions",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("DatabaseLatencyAndRecordsOverTime", new String[] {
                "DatabaseTopQueryTypes",
                "DatabaseTopQueryStatus",
                "DatabaseTopServers",
                "DatabaseTopHostPairs",
                "DatabaseTypes",
                "DatabaseTopVLAN",
            });
        }});
    };

    //**************************************************************************

}