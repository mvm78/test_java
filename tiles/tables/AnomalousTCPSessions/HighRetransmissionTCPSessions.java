package test_java.tiles.tables.AnomalousTCPSessions;

public class HighRetransmissionTCPSessions extends AnomalousTCPSessions {

    //**************************************************************************

    public HighRetransmissionTCPSessions() {

        this.setTitle("High Retransmission TCP Sessions");
        this.suffix = "pq 'client.rx > 10000 and server.rx > 10000'";
    }

    //**************************************************************************

}