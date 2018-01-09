package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCallingNumbers;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCallingNumbers extends Table {

    //**************************************************************************

    public TopSIPCallingNumbers() {

        this.common = new CommonTopSIPCallingNumbers();
        this.commonBy = new CommonByCalls();

        this.title = "SIP - Top Calling Numbers";
        this.prefix = "top 0 desc on srcnum";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}