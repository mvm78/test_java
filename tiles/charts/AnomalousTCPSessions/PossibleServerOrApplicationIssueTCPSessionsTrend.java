package test_java.tiles.charts.AnomalousTCPSessions;

public class PossibleServerOrApplicationIssueTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public PossibleServerOrApplicationIssueTCPSessionsTrend() {

        this.setTitle("Possible Server or Application Issue TCP Sessions Trend");
        this.setSuffix("pq 'rtt < .5 and response > 3' w 0 '|' TcpAgg count conn");
    }

    //**************************************************************************

}