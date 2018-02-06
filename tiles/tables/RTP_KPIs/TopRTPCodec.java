package test_java.tiles.tables.RTP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.RTP_KPIs.CommonTopRTPCodec;
import test_java.tiles.common.RTP_KPIs.CommonByRTP_KPIs;

public class TopRTPCodec extends Table {

    //**************************************************************************

    public TopRTPCodec() {

        final CommonTopRTPCodec commonInstance = new CommonTopRTPCodec();
        final CommonByRTP_KPIs commonByInstance = new CommonByRTP_KPIs();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("RTP - Top Codec");
        this.setPrefix("RtpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}