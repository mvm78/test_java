package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopQueryTypes;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopQueryTypes extends Table {

    //**************************************************************************

    public DatabaseTopQueryTypes() {

        this.common = new CommonTopQueryTypes();
        this.commonBy = new CommonByDatabaseLatencyAndSessions();

        this.title = "Database - Top Query Types";
        this.prefix = "DbAgg";
        this.setCommonData();
    }

    //**************************************************************************

}