package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPSources;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCallingIP extends Table {

    //**************************************************************************

    public TopSIPCallingIP() {

        final CommonTopSIPSources CommonInstance = new CommonTopSIPSources();
        final CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top Calling IPs");
        this.setPrefix("top 0 desc on src");
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}