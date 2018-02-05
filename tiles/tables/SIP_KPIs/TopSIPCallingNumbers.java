package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCallingNumbers;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCallingNumbers extends Table {

    //**************************************************************************

    public TopSIPCallingNumbers() {

        final CommonTopSIPCallingNumbers CommonInstance = new CommonTopSIPCallingNumbers();
        final CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top Calling Numbers");
        this.setPrefix("top 0 desc on srcnum");
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}