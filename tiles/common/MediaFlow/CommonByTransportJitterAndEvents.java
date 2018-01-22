package test_java.tiles.common.MediaFlow;

import test_java.tiles.common.*;
import java.util.LinkedHashMap;

public class CommonByTransportJitterAndEvents extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Application Packets", "number");
            put("Application Bytes", "number");
            put("Transport Event Packet Loss", "number");
            put("Transport Expected Packets", "number");
            put("Transport Packet Loss", "number");
            put("Mean Jitter", "number");
            put("Minimum Jitter", "number");
            put("Maximum Jitter", "number");
            put("Duration", "number");
            put("Application Media Event", "number");
            put("Monitor Event", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String [] getNoTallyColumns() {

        return new String [] {
            "Mean Jitter",
            "Minimum Jitter",
            "Maximum Jitter",
            "Duration",
            "Application Media Event",
            "Monitor Event",
        };
    }

    //**************************************************************************

}