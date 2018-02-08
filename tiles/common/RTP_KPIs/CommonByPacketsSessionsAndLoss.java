package test_java.tiles.common.RTP_KPIs;

import test_java.tiles.common.*;
import java.util.LinkedHashMap;

public class CommonByPacketsSessionsAndLoss extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "count pkts count loss count flows";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Packet Count", "number");
            put("Loss Count", "number");
            put("Session Count", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String[] getNoTallyColumns() {

        return new String[] {""};
    }

    //**************************************************************************

}
