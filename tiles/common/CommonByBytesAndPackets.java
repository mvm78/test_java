package test_java.tiles.common;

import java.util.LinkedHashMap;

public class CommonByBytesAndPackets extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "total total";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Packets", "number");
            put("Bytes", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String [] getNoTallyColumns() {

        return new String [] {};
    }

    //**************************************************************************

}
