package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Database.CommonTopTypes;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTypes extends Table {

    //**************************************************************************

    public DatabaseTypes() {

        final CommonTopTypes commonInstance = new CommonTopTypes();
        final CommonByDatabaseLatencyAndSessions commonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setTitle("Database Types");
        this.setPrefix("DbAgg");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}