package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCalledNumbers;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCalledNumbers extends Table {

    //**************************************************************************

    public TopSIPCalledNumbers() {

        final CommonTopSIPCalledNumbers commonInstance = new CommonTopSIPCalledNumbers();
        final CommonByCalls commonByInstance = new CommonByCalls();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("SIP - Top Called Numbers");
        this.setPrefix("top 0 desc on dstnum");
        this.setSplitChar(",");
        this.setColumnIncrement(0);
        this.setCommonData();
    }

    //**************************************************************************

}