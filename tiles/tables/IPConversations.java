package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class IPConversations extends Table {

    //**************************************************************************

    public IPConversations() {

        this.common = new CommonTopHostPairs();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "IP Conversations";
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