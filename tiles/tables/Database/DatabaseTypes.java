package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopTypes;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTypes extends Table {

    //**************************************************************************

    public DatabaseTypes() {

        this.common = new CommonTopTypes();
        this.commonBy = new CommonByDatabaseLatencyAndSessions();

        this.title = "Database Types";
        this.prefix = "DbAgg";
        this.setCommonData();
    }

    //**************************************************************************

}