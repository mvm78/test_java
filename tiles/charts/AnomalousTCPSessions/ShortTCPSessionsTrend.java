package test_java.tiles.charts.AnomalousTCPSessions;

public class ShortTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public ShortTCPSessionsTrend() {

        this.title = "Short TCP Sessions Trend";
        this.suffix = "pq 'dur < 1' w 0 '|' TcpAgg count conn";
    }

    //**************************************************************************

}