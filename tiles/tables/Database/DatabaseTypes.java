package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopTypes;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTypes extends Table {

    //**************************************************************************

    public DatabaseTypes() {

        final CommonTopTypes CommonInstance = new CommonTopTypes();
        final CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Database Types");
        this.setPrefix("DbAgg");
        this.setCommonData();
    }

    //**************************************************************************

}