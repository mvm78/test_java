package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopHostPairs extends Table {

    //**************************************************************************

    public DatabaseTopHostPairs() {

        final CommonTopHostPairs commonInstance = new CommonTopHostPairs();
        final CommonByDatabaseLatencyAndSessions commonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("Database - Top Host Pairs");
        this.setPrefix("DbAgg");
        this.setCommonData();
    }

    //**************************************************************************

}