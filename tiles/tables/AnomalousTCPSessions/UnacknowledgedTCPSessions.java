package test_java.tiles.tables.AnomalousTCPSessions;

public class UnacknowledgedTCPSessions extends AnomalousTCPSessions {

    //**************************************************************************

    public UnacknowledgedTCPSessions() {

        this.setTitle("Unacknowledged TCP Sessions");
        this.setSuffix("pq 'client.flags==syn and not server.flags==syn and not server.flags==rst'");
    }

    //**************************************************************************

}