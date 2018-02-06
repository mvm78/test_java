package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCalledUserAgents;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCalledUserAgents extends Table {

    //**************************************************************************

    public TopSIPCalledUserAgents() {

        final CommonTopSIPCalledUserAgents CommonInstance =
                new CommonTopSIPCalledUserAgents();
        final CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setTitle("SIP - Top Called User Agents");
        this.setPrefix("top 0 desc on dstuseragent");
        this.setSplitChar(",");
        this.setColumnIncrement(0);
        this.setCommonData();
    }

    //**************************************************************************

}