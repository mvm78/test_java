package test_java.tiles.tables.AnomalousTCPSessions;

public class UnacknowledgedTCPSessions extends AnomalousTCPSessions {

    //**************************************************************************

    public UnacknowledgedTCPSessions() {

        this.title = "Unacknowledged TCP Sessions";
        this.suffix = "pq 'client.flags==syn and not server.flags==syn and not server.flags==rst'";
    }

    //**************************************************************************

}