package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCallingUserAgents;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCallingUserAgents extends Table {

    //**************************************************************************

    public TopSIPCallingUserAgents() {

        this.common = new CommonTopSIPCallingUserAgents();

        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommonBy(CommonByInstance);
        this.title = "SIP - Top Calling User Agents";
        this.prefix = "top 0 desc on srcuseragent";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}