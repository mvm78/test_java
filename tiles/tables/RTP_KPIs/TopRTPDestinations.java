package test_java.tiles.tables.RTP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.RTP_KPIs.CommonTopRTPDestinations;
import test_java.tiles.common.RTP_KPIs.CommonByRTP_KPIs;

public class TopRTPDestinations extends Table {

    //**************************************************************************

    public TopRTPDestinations() {

        CommonTopRTPDestinations CommonInstance = new CommonTopRTPDestinations();
        CommonByRTP_KPIs CommonByInstance = new CommonByRTP_KPIs();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "RTP - Top Destinations";
        this.prefix = "RtpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}