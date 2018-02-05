package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopHostPairs extends Table {

    //**************************************************************************

    public DatabaseTopHostPairs() {

        this.common = new CommonTopHostPairs();

        CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommonBy(CommonByInstance);
        this.title = "Database - Top Host Pairs";
        this.prefix = "DbAgg";
        this.setCommonData();
    }

    //**************************************************************************

}