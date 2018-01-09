package test_java.tiles.tables;

import test_java.tiles.common.CommonTopCountryPairs;
import test_java.tiles.common.CommonByBytesAndPackets;

public class TopCountryPairsByBytesAndPackets extends Table {

    //**************************************************************************

    public TopCountryPairsByBytesAndPackets() {

        this.common = new CommonTopCountryPairs();
        this.commonBy = new CommonByBytesAndPackets();

        this.title = "Top Country Pair by Packets and Bytes";
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