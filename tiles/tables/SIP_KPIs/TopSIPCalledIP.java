package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPDestinations;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCalledIP extends Table {

    //**************************************************************************

    public TopSIPCalledIP() {

        final CommonTopSIPDestinations commonInstance = new CommonTopSIPDestinations();
        final CommonByCalls commonByInstance = new CommonByCalls();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("SIP - Top Called IPs");
        this.setPrefix("top 0 desc on dst");
        this.setSplitChar(",");
        this.setColumnIncrement(0);
    }

    //**************************************************************************

}