package test_java.tiles.charts.RTP_KPIs;

import test_java.tiles.charts.*;
import test_java.tiles.common.RTP_KPIs.CommonByPacketsSessionsAndLoss;

public class RTPPacketsSessionsAndLoss extends Chart {

    //**************************************************************************

    public RTPPacketsSessionsAndLoss() {

        final CommonByPacketsSessionsAndLoss commonByInstance =
                new CommonByPacketsSessionsAndLoss();

        this.setTitle("RTP - Packets, Sessions and Loss");
        this.setPrefix("RtpAgg");

        this.setCommonByData(commonByInstance);
    }

    //**************************************************************************

}