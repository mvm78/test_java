package test_java.tiles.charts.Database;

import test_java.tiles.charts.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseLatencyAndRecordsOverTime extends Chart {

    //**************************************************************************

    public DatabaseLatencyAndRecordsOverTime() {

        this.commonBy = new CommonByDatabaseLatencyAndSessions();

        this.title = "Database Latency and Records OverTime";
        this.prefix = "DbAgg";
        this.fields = new String [] {
            this.commonBy.getFields(),
        };
        this.filters = new String [] {};
        this.columns = this.commonBy.appendCompareColumns(
                new LinkedHashMap<String, HashMap<String, Object>>() {}, 1
        );
    }

    //**************************************************************************

}