package test_java.tiles.tables.RTP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.RTP_KPIs.CommonTopRTPVLAN;
import test_java.tiles.common.RTP_KPIs.CommonByRTP_KPIs;

public class TopRTPVLAN extends Table {

    //**************************************************************************

    public TopRTPVLAN() {

        CommonTopRTPVLAN CommonInstance = new CommonTopRTPVLAN();
        CommonByRTP_KPIs CommonByInstance = new CommonByRTP_KPIs();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "RTP - Top VLAN";
        this.prefix = "RtpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}