package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPVLAN;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPVLAN extends Table {

    //**************************************************************************

    public TopSIPVLAN() {

        final CommonTopSIPVLAN commonInstance = new CommonTopSIPVLAN();
        final CommonByCalls commonByInstance = new CommonByCalls();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("SIP - Top VLAN");
        this.setPrefix("top 0 desc on vlan");
        this.setSplitChar(",");
        this.setColumnIncrement(0);
        this.setCommonData();
    }

    //**************************************************************************

}