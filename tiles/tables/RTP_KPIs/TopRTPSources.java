package test_java.tiles.tables.RTP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.RTP_KPIs.CommonTopRTPSources;
import test_java.tiles.common.RTP_KPIs.CommonByRTP_KPIs;

public class TopRTPSources extends Table {

    //**************************************************************************

    public TopRTPSources() {

        this.common = new CommonTopRTPSources();
        this.commonBy = new CommonByRTP_KPIs();

        this.title = "RTP - Top Sources";
        this.prefix = "RtpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}