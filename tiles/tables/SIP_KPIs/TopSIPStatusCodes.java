package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPStatusCodes;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPStatusCodes extends Table {

    //**************************************************************************

    public TopSIPStatusCodes() {

        final CommonTopSIPStatusCodes CommonInstance = new CommonTopSIPStatusCodes();
        final CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top SIP Status Codes");
        this.setPrefix("top 0 desc on errorcode");
        this.setSplitChar(",");
        this.setColumnIncrement(0);
        this.setCommonData();
    }

    //**************************************************************************

}