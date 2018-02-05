package test_java.tiles.tables.AnomalousTCPSessions;

public class ServerResetNoBytesTCPSessions extends AnomalousTCPSessions {

    //**************************************************************************

    public ServerResetNoBytesTCPSessions() {

        this.setTitle("Server Reset (No Bytes) TCP Sessions");
        this.setSuffix("pq 'client.byte==0 and server.flags==rst'");
    }

    //**************************************************************************

}