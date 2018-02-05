package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPConnectionTypes;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPConnectionTypes extends Table {

    //**************************************************************************

    public TopSIPConnectionTypes() {

        CommonTopSIPConnectionTypes CommonInstance =
                new CommonTopSIPConnectionTypes();
        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top Connection Types");
        this.prefix = "top 0 desc on connectiontype";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}