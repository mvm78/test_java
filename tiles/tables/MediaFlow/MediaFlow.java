package test_java.tiles.tables.MediaFlow;

import test_java.tiles.tables.Table;
import test_java.tiles.common.MediaFlow.CommonMediaFlow;
import test_java.tiles.common.MediaFlow.CommonByTransportJitterAndEvents;

public class MediaFlow extends Table {

    //**************************************************************************

    public MediaFlow() {

        final CommonMediaFlow CommonInstance = new CommonMediaFlow();
        final CommonByTransportJitterAndEvents CommonByInstance =
                new CommonByTransportJitterAndEvents();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("Media Flow");
        this.setPrefix("MediaFlow");
        this.setFields(new String [] {
            this.getCommon().getFields()[0] + " " + this.getCommonBy().getFields(),
        });
        this.filters = this.getCommon().getFilters();
        this.filterColumns = this.getCommon().getFilterColumns();

        this.columns = this.getCommonBy().appendCompareColumns(this.filterColumns, 2);
    }

    //**************************************************************************

}