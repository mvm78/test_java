package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPDestinations;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCalledIP extends Table {

    //**************************************************************************

    public TopSIPCalledIP() {

        this.common = new CommonTopSIPDestinations();

        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommonBy(CommonByInstance);
        this.title = "SIP - Top Called IPs";
        this.prefix = "top 0 desc on dst";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}