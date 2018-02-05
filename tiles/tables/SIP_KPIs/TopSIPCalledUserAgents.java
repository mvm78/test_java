package test_java.tiles.tables.SIP_KPIs;

import test_java.tiles.tables.Table;
import test_java.tiles.common.SIP_KPIs.CommonTopSIPCalledUserAgents;
import test_java.tiles.common.SIP_KPIs.CommonByCalls;

public class TopSIPCalledUserAgents extends Table {

    //**************************************************************************

    public TopSIPCalledUserAgents() {

        this.common = new CommonTopSIPCalledUserAgents();

        CommonByCalls CommonByInstance = new CommonByCalls();

        this.setCommonBy(CommonByInstance);
        this.title = "SIP - Top Called User Agents";
        this.prefix = "top 0 desc on dstuseragent";
        this.splitChar = ",";
        this.columnIncrement = 0;
        this.setCommonData();
    }

    //**************************************************************************

}