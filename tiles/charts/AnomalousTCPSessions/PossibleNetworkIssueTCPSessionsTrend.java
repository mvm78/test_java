package test_java.tiles.charts.AnomalousTCPSessions;

public class PossibleNetworkIssueTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public PossibleNetworkIssueTCPSessionsTrend() {

        this.setTitle("Possible Network Issue TCP Sessions Trend");
        this.setSuffix("pq 'rtt > 1 and response < 1' w 0 '|' TcpAgg count conn");
    }

    //**************************************************************************

}