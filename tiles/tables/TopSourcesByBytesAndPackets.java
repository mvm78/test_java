package test_java.tiles.tables;

import test_java.tiles.common.CommonTopSources;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopSourcesByBytesAndPackets extends Table {

    //**************************************************************************

    public TopSourcesByBytesAndPackets() {

        this.common = new CommonTopSources();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "Top Sources by Bytes and Packets";
        this.prefix = "NetDist";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
        this.checkNot = this.common.getCheckNot();
    }

    //**************************************************************************

}