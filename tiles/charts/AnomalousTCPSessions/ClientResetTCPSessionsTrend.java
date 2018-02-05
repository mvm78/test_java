package test_java.tiles.charts.AnomalousTCPSessions;

public class ClientResetTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public ClientResetTCPSessionsTrend() {

        this.setTitle("Client Reset TCP Sessions Trend");
        this.suffix = "pq 'client.flags==rst' w 0 '|' TcpAgg count conn";
    }

    //**************************************************************************

}