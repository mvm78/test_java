package test_java.tiles.tables.AnomalousTCPSessions;

public class ClientResetTCPSessions extends AnomalousTCPSessions {

    //**************************************************************************

    public ClientResetTCPSessions() {

        this.setTitle("Client Reset TCP Sessions");
        this.suffix = "pq 'client.flags==rst'";
    }

    //**************************************************************************

}