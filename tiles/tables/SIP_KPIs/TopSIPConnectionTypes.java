package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPConnectionTypes;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPConnectionTypes extends Table {

    //**************************************************************************

    public TopSIPConnectionTypes() {

        final CommonTopSIPConnectionTypes commonInstance =
                new CommonTopSIPConnectionTypes();
        final CommonByCalls commonByInstance = new CommonByCalls();

        this.setTitle("SIP - Top Connection Types");
        this.setPrefix("top 0 desc on connectiontype");
        this.setSplitChar(",");
        this.setColumnIncrement(0);

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

}