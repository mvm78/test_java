package test_java.tiles.tables;

import test_java.tiles.common.CommonTopHostPairs;
import test_java.tiles.common.CommonByTCPBytes;

public class TopTCPConversationsByBytes extends Table {

    //**************************************************************************

    public TopTCPConversationsByBytes() {

        this.common = new CommonTopHostPairs();
        this.commonBy = new CommonByTCPBytes();

        this.isSingleLine = true;
        this.title = "Top TCP Conversations by Bytes";
        this.prefix = "TcpAgg flowsegments";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

}