package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopQueryTypes;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopQueryTypes extends Table {

    //**************************************************************************

    public DatabaseTopQueryTypes() {

        final CommonTopQueryTypes commonInstance = new CommonTopQueryTypes();
        final CommonByDatabaseLatencyAndSessions commonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("Database - Top Query Types");
        this.setPrefix("DbAgg");
    }

    //**************************************************************************

}