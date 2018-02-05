package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCallingUserAgents;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCallingUserAgents extends Table {

    //**************************************************************************

    public TopSIPCallingUserAgents() {

        CommonTopSIPCallingUserAgents CommonInstance =
                new CommonTopSIPCallingUserAgents();
        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.title = "SIP - Top Calling User Agents";
        this.prefix = "top 0 desc on srcuseragent";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}