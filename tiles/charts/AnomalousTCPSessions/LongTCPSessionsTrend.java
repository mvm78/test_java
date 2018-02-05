package test_java.tiles.charts.AnomalousTCPSessions;

public class LongTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public LongTCPSessionsTrend() {

        this.setTitle("Long TCP Sessions Trend");
        this.setSuffix("pq 'dur > 60' w 0 '|' TcpAgg count conn");
    }

    //**************************************************************************

}