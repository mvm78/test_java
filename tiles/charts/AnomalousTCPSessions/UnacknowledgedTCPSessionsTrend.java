package test_java.tiles.charts.AnomalousTCPSessions;

public class UnacknowledgedTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public UnacknowledgedTCPSessionsTrend() {

        this.title = "Unacknowledged TCP Sessions Trend";
        this.suffix = "pq 'client.flags==syn and not server.flags==syn and not server.flags==rst' w 0 '|' TcpAgg count conn";
    }

    //**************************************************************************

}