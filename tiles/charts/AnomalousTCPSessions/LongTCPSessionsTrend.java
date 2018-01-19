package test_java.tiles.charts.AnomalousTCPSessions;

public class LongTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public LongTCPSessionsTrend() {

        this.title = "Long TCP Sessions Trend";
        this.suffix = "pq 'dur > 60' w 0 '|' TcpAgg count conn";
    }

    //**************************************************************************

}