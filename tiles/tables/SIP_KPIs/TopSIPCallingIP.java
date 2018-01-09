package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPSources;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCallingIP extends Table {

    //**************************************************************************

    public TopSIPCallingIP() {

        this.common = new CommonTopSIPSources();
        this.commonBy = new CommonByCalls();

        this.title = "SIP - Top Calling IPs";
        this.prefix = "top 0 desc on src";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}