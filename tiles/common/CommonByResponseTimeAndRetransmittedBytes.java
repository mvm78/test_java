package test_java.tiles.common;

import java.util.LinkedHashMap;

public class CommonByResponseTimeAndRetransmittedBytes extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "count conn mean rtt mean response count rx count byte count vrtt count vresp";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Connections", "number");
            put("Network Time", "number");
            put("Response Time", "number");
            put("Retransmitted Bytes", "number");
            put("TCP Bytes", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String[] getNoTallyColumns() {

        return new String[] {
            "Network Time",
            "Response Time",
        };
    }

    //**************************************************************************

}