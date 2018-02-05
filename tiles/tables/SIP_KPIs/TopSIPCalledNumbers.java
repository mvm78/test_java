package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCalledNumbers;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCalledNumbers extends Table {

    //**************************************************************************

    public TopSIPCalledNumbers() {

        final CommonTopSIPCalledNumbers CommonInstance = new CommonTopSIPCalledNumbers();
        final CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top Called Numbers");
        this.setPrefix("top 0 desc on dstnum");
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}