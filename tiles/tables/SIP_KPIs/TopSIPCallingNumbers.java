package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCallingNumbers;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCallingNumbers extends Table {

    //**************************************************************************

    public TopSIPCallingNumbers() {

        final CommonTopSIPCallingNumbers commonInstance = new CommonTopSIPCallingNumbers();
        final CommonByCalls commonByInstance = new CommonByCalls();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("SIP - Top Calling Numbers");
        this.setPrefix("top 0 desc on srcnum");
        this.setSplitChar(",");
        this.setColumnIncrement(0);
    }

    //**************************************************************************

}