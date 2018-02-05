package test_java.reports;

import java.util.*;

public class DatabasePerformance extends Report {

    //**************************************************************************

    public DatabasePerformance() {

        this.setAppPath("/usr/local/mercury/bin/agg-db");
        this.refresh = "refreshTO 5.0";

        this.title = "Database Performance";
        this.tilesFolder = "Database";

        this.tileList = new HashMap<String, String []>() {{
            put("charts", new String [] {
                "DatabaseLatencyAndRecordsOverTime",
            });
            put("tables", new String [] {
                "DatabaseTopQueryTypes",
                "DatabaseTopQueryStatus",
                "DatabaseTopServers",
                "DatabaseTopHostPairs",
                "DatabaseTypes",
                "DatabaseTopVLAN",
                "DatabaseSessions",
            });
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("DatabaseLatencyAndRecordsOverTime", new String [] {
                "DatabaseTopQueryTypes",
                "DatabaseTopQueryStatus",
                "DatabaseTopServers",
                "DatabaseTopHostPairs",
                "DatabaseTypes",
                "DatabaseTopVLAN",
            });
        }};
    };

    //**************************************************************************

}