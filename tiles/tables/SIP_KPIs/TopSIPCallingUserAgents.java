package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCallingUserAgents;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCallingUserAgents extends Table {

    //**************************************************************************

    public TopSIPCallingUserAgents() {

        final CommonTopSIPCallingUserAgents commonInstance =
                new CommonTopSIPCallingUserAgents();
        final CommonByCalls commonByInstance = new CommonByCalls();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setTitle("SIP - Top Calling User Agents");
        this.setPrefix("top 0 desc on srcuseragent");
        this.setSplitChar(",");
        this.setColumnIncrement(0);
        this.setCommonData();
    }

    //**************************************************************************

}