package test_java.tiles.charts.AnomalousTCPSessions;

public class HighRetransmissionTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public HighRetransmissionTCPSessionsTrend() {

        this.setTitle("High Retransmission TCP Sessions Trend");
        this.suffix = "pq 'client.rx > 10000 and server.rx > 10000' w 0 '|' TcpAgg count conn";
    }

    //**************************************************************************

}