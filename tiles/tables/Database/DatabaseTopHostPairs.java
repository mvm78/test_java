package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopHostPairs extends Table {

    //**************************************************************************

    public DatabaseTopHostPairs() {

        final CommonTopHostPairs CommonInstance = new CommonTopHostPairs();
        final CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Database - Top Host Pairs");
        this.setPrefix("DbAgg");
        this.setCommonData();
    }

    //**************************************************************************

}