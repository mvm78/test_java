package test_java.tiles.tables.RTP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.RTP_KPIs.CommonTopRTPSources;
import test_java.tiles.common.RTP_KPIs.CommonByRTP_KPIs;

public class TopRTPSources extends Table {

    //**************************************************************************

    public TopRTPSources() {

        final CommonTopRTPSources CommonInstance = new CommonTopRTPSources();
        final CommonByRTP_KPIs CommonByInstance = new CommonByRTP_KPIs();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("RTP - Top Sources");
        this.setPrefix("RtpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}