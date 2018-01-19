package test_java.tiles.tables.AnomalousTCPSessions;

public class ServerResetNoBytesTCPSessions extends AnomalousTCPSessions {

    //**************************************************************************

    public ServerResetNoBytesTCPSessions() {

        this.title = "Server Reset (No Bytes) TCP Sessions";
        this.suffix = "pq 'client.byte==0 and server.flags==rst'";
    }

    //**************************************************************************

}