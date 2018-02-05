package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopServers extends Table {

    //**************************************************************************

    public DatabaseTopServers() {

        CommonTopServers CommonInstance = new CommonTopServers();
        CommonByDatabaseLatencyAndSessions CommonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "Database - Top Servers";
        this.prefix = "DbAgg";
        this.setCommonData();
    }

    //**************************************************************************

}