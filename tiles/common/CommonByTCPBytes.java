package test_java.tiles.common;

import java.util.LinkedHashMap;

public class CommonByTCPBytes extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "count conn count goodput count thruput mean rtt mean response count rx count byte count vrtt count vresp mean dur count pkt";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Connections", "number");
            put("Goodput", "number");
            put("Throughput", "number");
            put("Network Time", "number");
            put("Response Time", "number");
            put("Retransmitted Bytes", "number");
            put("TCP Bytes", "number");
            put("Unknown 1", "number");
            put("Unknown 2", "number");
            put("Average Duration", "number");
            put("TCP Packets", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String [] getNoTallyColumns() {

        return new String [] {
           "Network Time",
            "Response Time",
            "Unknown 1",
            "Unknown 2",
            "Average Duration",
        };
    }

    //**************************************************************************

}