package test_java.tiles.tables.RTP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.RTP_KPIs.CommonTopRTPVLAN;
import test_java.tiles.common.RTP_KPIs.CommonByRTP_KPIs;

public class TopRTPVLAN extends Table {

    //**************************************************************************

    public TopRTPVLAN() {

        this.common = new CommonTopRTPVLAN();
        this.commonBy = new CommonByRTP_KPIs();

        this.title = "RTP - Top VLAN";
        this.prefix = "RtpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}