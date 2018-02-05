package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPDestinations;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCalledIP extends Table {

    //**************************************************************************

    public TopSIPCalledIP() {

        final CommonTopSIPDestinations CommonInstance = new CommonTopSIPDestinations();
        final CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top Called IPs");
        this.setPrefix("top 0 desc on dst");
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}