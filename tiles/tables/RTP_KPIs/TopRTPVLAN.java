package test_java.tiles.tables.RTP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.RTP_KPIs.CommonTopRTPVLAN;
import test_java.tiles.common.RTP_KPIs.CommonByRTP_KPIs;

public class TopRTPVLAN extends Table {

    //**************************************************************************

    public TopRTPVLAN() {

        final CommonTopRTPVLAN commonInstance = new CommonTopRTPVLAN();
        final CommonByRTP_KPIs commonByInstance = new CommonByRTP_KPIs();

        this.setTitle("RTP - Top VLAN");
        this.setPrefix("RtpAgg flowsegments");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}