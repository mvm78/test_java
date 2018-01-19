package test_java.tiles.tables.AnomalousTCPSessions;

public class ClientResetTCPSessions extends AnomalousTCPSessions {

    //**************************************************************************

    public ClientResetTCPSessions() {

        this.title = "Client Reset TCP Sessions";
        this.suffix = "pq 'client.flags==rst'";
    }

    //**************************************************************************

}