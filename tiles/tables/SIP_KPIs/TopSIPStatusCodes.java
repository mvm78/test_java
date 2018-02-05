package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPStatusCodes;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPStatusCodes extends Table {

    //**************************************************************************

    public TopSIPStatusCodes() {

        CommonTopSIPStatusCodes CommonInstance = new CommonTopSIPStatusCodes();
        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "SIP - Top SIP Status Codes";
        this.prefix = "top 0 desc on errorcode";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}