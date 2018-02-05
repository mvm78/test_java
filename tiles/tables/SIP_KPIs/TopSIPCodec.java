package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCodec;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCodec extends Table {

    //**************************************************************************

    public TopSIPCodec() {

        final CommonTopSIPCodec CommonInstance = new CommonTopSIPCodec();
        final CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top Codec");
        this.setPrefix("top 0 desc on codec");
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}