package test_java.tiles.charts.AnomalousTCPSessions;

public class ShortTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public ShortTCPSessionsTrend() {

        this.setTitle("Short TCP Sessions Trend");
        this.setSuffix("pq 'dur < 1' w 0 '|' TcpAgg count conn");
    }

    //**************************************************************************

}