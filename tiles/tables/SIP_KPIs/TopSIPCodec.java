package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCodec;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCodec extends Table {

    //**************************************************************************

    public TopSIPCodec() {

        final CommonTopSIPCodec commonInstance = new CommonTopSIPCodec();
        final CommonByCalls commonByInstance = new CommonByCalls();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("SIP - Top Codec");
        this.setPrefix("top 0 desc on codec");
        this.setSplitChar(",");
        this.setColumnIncrement(0);
        this.setCommonData();
    }

    //**************************************************************************

}