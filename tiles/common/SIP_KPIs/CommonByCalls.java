package test_java.tiles.common.SIP_KPIs;

import java.util.LinkedHashMap;
import test_java.tiles.common.CommonBy;

public class CommonByCalls extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Calls", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String[] getNoTallyColumns() {

        return new String[] {};
    }

    //**************************************************************************

}