package test_java.tiles.common.RTP_KPIs;

import java.util.LinkedHashMap;
import test_java.tiles.common.CommonBy;

public class CommonByRTP_KPIs extends CommonBy {

    //**************************************************************************

    @Override
    public String getFields() {

        return "count pkts count bytes count loss mean pctloss max iatjitter mean jitter count cnpkts count cnbytes mean pctcn count badpkts count badbytes mean pctbad mean delay max delay mean mos count flows mean duration";
    }

    //**************************************************************************

    @Override
    public LinkedHashMap<String, String> getCompareColumns() {

        return new LinkedHashMap<String, String>() {{
            put("Packet Count", "number");
            put("Byte Count", "number");
            put("Loss Count", "number");
            put("Packet Loss Percentage", "number");
            put("Maximum Interarrival Time Jitter", "number");
            put("Average Jitter", "number");
            put("Count of Comfort Noise Packets", "number");
            put("Percentage of Comfort Noise Packets", "number");
            put("Count of Comfort Noise Bytes", "number");
            put("Count Of Bad Packets", "number");
            put("Count Of Bad Bytes", "number");
            put("Percentage Of Bad Packets", "number");
            put("Average Delta", "number");
            put("Max Delta", "number");
            put("MOS Score", "number");
            put("Session Count", "number");
            put("Duration", "number");
        }};
    }

    //**************************************************************************

    @Override
    public String [] getNoTallyColumns() {

        return new String [] {
            "Packet Loss Percentage",
            "Average Jitter",
            "Maximum Interarrival Time Jitter",
            "Average Delta",
            "Max Delta",
            "MOS Score",
            "Percentage of Comfort Noise Packets",
            "Percentage Of Bad Packets",
            "Duration",
        };
    }

    //**************************************************************************

}