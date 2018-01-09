package test_java.tiles.tables;

import test_java.tiles.common.CommonTOS;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopTOSByBytesAndPackets extends Table {

    //**************************************************************************

    public TopTOSByBytesAndPackets() {

        this.common = new CommonTOS();
        this.commonBy = new CommonByBytesAndPackets();

        this.isSingleLine = true;
        this.title = "Top TOS by Bytes and Packets";
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