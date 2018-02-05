package test_java.tiles.charts.Database;

import test_java.tiles.charts.*;

import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseLatencyAndRecordsOverTime extends Chart {

    //**************************************************************************

    public DatabaseLatencyAndRecordsOverTime() {

        CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommonBy(CommonByInstance);
        this.title = "Database Latency and Records OverTime";
        this.prefix = "DbAgg";
        this.setCommonByData();
    }

    //**************************************************************************

}