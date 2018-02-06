package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPSources;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCallingIP extends Table {

    //**************************************************************************

    public TopSIPCallingIP() {

        final CommonTopSIPSources commonInstance = new CommonTopSIPSources();
        final CommonByCalls commonByInstance = new CommonByCalls();

        this.setCommonData(commonInstance, commonByInstance);

        this.setTitle("SIP - Top Calling IPs");
        this.setPrefix("top 0 desc on src");
        this.setSplitChar(",");
        this.setColumnIncrement(0);
    }

    //**************************************************************************

}