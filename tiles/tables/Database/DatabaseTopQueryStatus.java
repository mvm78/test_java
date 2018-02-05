package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopQueryStatus;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopQueryStatus extends Table {

    //**************************************************************************

    public DatabaseTopQueryStatus() {

        CommonTopQueryStatus CommonInstance = new CommonTopQueryStatus();
        CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Database - Top Query Status";
        this.prefix = "DbAgg";
        this.setCommonData();
    }

    //**************************************************************************

}