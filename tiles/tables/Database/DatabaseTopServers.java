package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopServers extends Table {

    //**************************************************************************

    public DatabaseTopServers() {

        final CommonTopServers CommonInstance = new CommonTopServers();
        final CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Database - Top Servers");
        this.setPrefix("DbAgg");
        this.setCommonData();
    }

    //**************************************************************************

}