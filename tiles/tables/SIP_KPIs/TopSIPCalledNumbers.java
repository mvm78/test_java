package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCalledNumbers;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCalledNumbers extends Table {

    //**************************************************************************

    public TopSIPCalledNumbers() {

        this.common = new CommonTopSIPCalledNumbers();

        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommonBy(CommonByInstance);
        this.title = "SIP - Top Called Numbers";
        this.prefix = "top 0 desc on dstnum";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}