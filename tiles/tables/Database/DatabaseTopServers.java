package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopServers extends Table {

    //**************************************************************************

    public DatabaseTopServers() {

        final CommonTopServers commonInstance = new CommonTopServers();
        final CommonByDatabaseLatencyAndSessions commonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setTitle("Database - Top Servers");
        this.setPrefix("DbAgg");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}