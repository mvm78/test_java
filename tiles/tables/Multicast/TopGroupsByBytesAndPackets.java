package test_java.tiles.tables.Multicast;

import test_java.tiles.tables.Table;
import test_java.tiles.common.Multicast.CommonTopGroups;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopGroupsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopGroupsByBytesAndPackets() {

        this.common = new CommonTopGroups();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "Multicast - Top Groups";
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