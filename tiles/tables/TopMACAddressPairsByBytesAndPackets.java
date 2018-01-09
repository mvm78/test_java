package test_java.tiles.tables;

import test_java.tiles.common.CommonTopMACAddressPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopMACAddressPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopMACAddressPairsByBytesAndPackets() {

        this.common = new CommonTopMACAddressPairs();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "Top MAC Address Pairs by Packets and Bytes";
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