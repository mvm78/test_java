package test_java.tiles.charts.RTP_KPIs;

import test_java.tiles.charts.*;
import test_java.tiles.common.RTP_KPIs.CommonByPacketsSessionsAndLoss;

public class RTPPacketsSessionsAndLoss extends Chart {

    //**************************************************************************

    public RTPPacketsSessionsAndLoss() {

        CommonByPacketsSessionsAndLoss CommonByInstance =
                new CommonByPacketsSessionsAndLoss();

        this.setCommonBy(CommonByInstance);
        this.setTitle("RTP - Packets, Sessions and Loss");
        this.prefix = "RtpAgg";
        this.setCommonByData();
    }

    //**************************************************************************

}