package test_java.tiles.tables.RTP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.RTP_KPIs.CommonTopRTPCodec;
import test_java.tiles.common.RTP_KPIs.CommonByRTP_KPIs;

public class TopRTPCodec extends Table {

    //**************************************************************************

    public TopRTPCodec() {

        CommonTopRTPCodec CommonInstance = new CommonTopRTPCodec();
        CommonByRTP_KPIs CommonByInstance = new CommonByRTP_KPIs();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "RTP - Top Codec";
        this.prefix = "RtpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}