package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPVLAN;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPVLAN extends Table {

    //**************************************************************************

    public TopSIPVLAN() {

        CommonTopSIPVLAN CommonInstance = new CommonTopSIPVLAN();
        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top VLAN");
        this.prefix = "top 0 desc on vlan";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}