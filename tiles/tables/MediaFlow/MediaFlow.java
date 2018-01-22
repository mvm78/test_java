package test_java.tiles.tables.MediaFlow;

import test_java.tiles.tables.Table;
import test_java.tiles.common.MediaFlow.CommonMediaFlow;
import test_java.tiles.common.MediaFlow.CommonByTransportJitterAndEvents;

public class MediaFlow extends Table {

    //**************************************************************************

    public MediaFlow() {

        this.common = new CommonMediaFlow();
        this.commonBy = new CommonByTransportJitterAndEvents();

        this.title = "Media Flow";
        this.prefix = "MediaFlow";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();

        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 2);
    }

    //**************************************************************************

}