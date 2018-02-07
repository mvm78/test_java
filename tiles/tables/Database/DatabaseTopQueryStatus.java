package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopQueryStatus;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopQueryStatus extends Table {

    //**************************************************************************

    public DatabaseTopQueryStatus() {

        final CommonTopQueryStatus commonInstance = new CommonTopQueryStatus();
        final CommonByDatabaseLatencyAndSessions commonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setTitle("Database - Top Query Status");
        this.setPrefix("DbAgg");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}