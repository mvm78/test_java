package test_java.tiles.tables.MediaFlow;

import test_java.tiles.tables.Table;
import test_java.tiles.common.MediaFlow.CommonMediaFlow;
import test_java.tiles.common.MediaFlow.CommonByTransportJitterAndEvents;

public class MediaFlow extends Table {

    //**************************************************************************

    public MediaFlow() {

        final CommonMediaFlow commonInstance = new CommonMediaFlow();
        final CommonByTransportJitterAndEvents commonByInstance =
                new CommonByTransportJitterAndEvents();

        this.setColumnIncrement(2);
        this.setTitle("Media Flow");
        this.setPrefix("MediaFlow");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}