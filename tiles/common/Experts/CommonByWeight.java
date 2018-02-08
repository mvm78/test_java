package test_java.tiles.common.Experts;

import test_java.tiles.common.*;
import java.util.LinkedHashMap;

public class CommonByWeight extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("HTTP Network Weight", "number");
            put("HTTP Application Weight", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String[] getNoTallyColumns() {

        return new String[] {
            "HTTP Network Weight",
            "HTTP Application Weight",
        };
    }

    //**************************************************************************

}