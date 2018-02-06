package test_java.tiles.tables.RTP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.RTP_KPIs.CommonTopRTPDestinations;
import test_java.tiles.common.RTP_KPIs.CommonByRTP_KPIs;

public class TopRTPDestinations extends Table {

    //**************************************************************************

    public TopRTPDestinations() {

        final CommonTopRTPDestinations commonInstance = new CommonTopRTPDestinations();
        final CommonByRTP_KPIs commonByInstance = new CommonByRTP_KPIs();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("RTP - Top Destinations");
        this.setPrefix("RtpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}