package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPDestinations;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCalledIP extends Table {

    //**************************************************************************

    public TopSIPCalledIP() {

        CommonTopSIPDestinations CommonInstance = new CommonTopSIPDestinations();
        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top Called IPs");
        this.prefix = "top 0 desc on dst";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}