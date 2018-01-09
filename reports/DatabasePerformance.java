package test_java.reports;

import java.util.*;

public class DatabasePerformance extends Report {

    //**************************************************************************

    public DatabasePerformance() {

        this.appPath = "/usr/local/mercury/bin/agg-db";
        this.refresh = "refreshTO 5.0";

        this.title = "Database Performance";
        this.tilesFolder = "Database";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("DatabaseLatencyAndRecordsOverTime");
            }});
            put("tables", new ArrayList<String>() {{
                add("DatabaseTopQueryTypes");
                add("DatabaseTopQueryStatus");
                add("DatabaseTopServers");
                add("DatabaseTopHostPairs");
                add("DatabaseTypes");
                add("DatabaseTopVLAN");
                add("DatabaseSessions");
            }});
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

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}