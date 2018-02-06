package test_java.tiles.tables.MediaFlow;

import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.tables.Table;
import test_java.tiles.common.MediaFlow.CommonMediaFlow;
import test_java.tiles.common.MediaFlow.CommonByTransportJitterAndEvents;

public class MediaFlow extends Table {

    //**************************************************************************

    public MediaFlow() {

        final CommonMediaFlow commonInstance = new CommonMediaFlow();
        final CommonByTransportJitterAndEvents commonByInstance =
                new CommonByTransportJitterAndEvents();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);

        final String [] instanceFilters = this.getCommon().getFilters();
        final LinkedHashMap<String, HashMap<String, Object>> instanceFilterColumns =
                this.getCommon().getFilterColumns();
        final LinkedHashMap<String, HashMap<String, Object>> instanceColumns =
                this.getCommonBy().appendCompareColumns(instanceFilterColumns, 2);

        this.setTitle("Media Flow");
        this.setPrefix("MediaFlow");
        this.setFields(new String [] {
            this.getCommon().getFields()[0] + " " + this.getCommonBy().getFields(),
        });
        this.setFilters(instanceFilters);
        this.setFilterColumns(instanceFilterColumns);
        this.setColumns(instanceColumns);
    }

    //**************************************************************************

}