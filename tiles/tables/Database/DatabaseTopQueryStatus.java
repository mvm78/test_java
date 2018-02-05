package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopQueryStatus;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopQueryStatus extends Table {

    //**************************************************************************

    public DatabaseTopQueryStatus() {

        final CommonTopQueryStatus CommonInstance = new CommonTopQueryStatus();
        final CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Database - Top Query Status");
        this.setPrefix("DbAgg");
        this.setCommonData();
    }

    //**************************************************************************

}