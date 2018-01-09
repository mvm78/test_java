package test_java.tiles.charts.RTP_KPIs;

import test_java.tiles.charts.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

import test_java.tiles.common.RTP_KPIs.CommonByPacketsSessionsAndLoss;

public class RTPPacketsSessionsAndLoss extends Chart {

    //**************************************************************************

    public RTPPacketsSessionsAndLoss() {

        this.commonBy = new CommonByPacketsSessionsAndLoss();

        this.title = "RTP - Packets, Sessions and Loss";
        this.prefix = "RtpAgg";
        this.fields = new String [] {
            this.commonBy.getFields(),
        };
        this.filters = new String [] {};
        this.columns = this.commonBy.appendCompareColumns(
                new LinkedHashMap<String, HashMap<String, Object>>() {}, 1
        );
    }

    //**************************************************************************

}