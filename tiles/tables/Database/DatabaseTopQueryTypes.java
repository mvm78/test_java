package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopQueryTypes;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopQueryTypes extends Table {

    //**************************************************************************

    public DatabaseTopQueryTypes() {

        this.common = new CommonTopQueryTypes();

        CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommonBy(CommonByInstance);
        this.title = "Database - Top Query Types";
        this.prefix = "DbAgg";
        this.setCommonData();
    }

    //**************************************************************************

}