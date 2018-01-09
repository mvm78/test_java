package test_java.tiles.tables.Database;

import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonTopServers;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopServers extends Table {

    //**************************************************************************

    public DatabaseTopServers() {

        this.common = new CommonTopServers();
        this.commonBy = new CommonByDatabaseLatencyAndSessions();

        this.title = "Database - Top Servers";
        this.prefix = "DbAgg";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}