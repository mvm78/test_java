package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCodec;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCodec extends Table {

    //**************************************************************************

    public TopSIPCodec() {

        this.common = new CommonTopSIPCodec();

        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommonBy(CommonByInstance);
        this.title = "SIP - Top Codec";
        this.prefix = "top 0 desc on codec";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}