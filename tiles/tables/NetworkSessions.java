package test_java.tiles.tables;

import test_java.tiles.common.CommonNetwork;
import test_java.tiles.common.CommonByBytesAndPackets;

public class NetworkSessions extends Table {

    //**************************************************************************

    public NetworkSessions() {

        this.common = new CommonNetwork();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "Network - Sessions";
        this.prefix = "NetDist";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}