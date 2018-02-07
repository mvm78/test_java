package test_java.tiles.charts.Database;

import test_java.tiles.charts.*;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseLatencyAndRecordsOverTime extends Chart {

    //**************************************************************************

    public DatabaseLatencyAndRecordsOverTime() {

        final CommonByDatabaseLatencyAndSessions commonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setTitle("Database Latency and Records OverTime");
        this.setPrefix("DbAgg");

        this.setCommonByData(commonByInstance);
    }

    //**************************************************************************

}