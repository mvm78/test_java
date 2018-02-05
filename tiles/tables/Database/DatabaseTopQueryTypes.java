package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopQueryTypes;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopQueryTypes extends Table {

    //**************************************************************************

    public DatabaseTopQueryTypes() {

        final CommonTopQueryTypes CommonInstance = new CommonTopQueryTypes();
        final CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Database - Top Query Types");
        this.setPrefix("DbAgg");
        this.setCommonData();
    }

    //**************************************************************************

}