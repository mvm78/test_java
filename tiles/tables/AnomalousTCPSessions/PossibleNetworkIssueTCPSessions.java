package test_java.tiles.tables.AnomalousTCPSessions;

public class PossibleNetworkIssueTCPSessions extends AnomalousTCPSessions {

    //**************************************************************************

    public PossibleNetworkIssueTCPSessions() {

        this.title = "Possible Network Issue TCP Sessions";
        this.suffix = "pq 'rtt > 1 and response < 1'";
    }

    //**************************************************************************

}