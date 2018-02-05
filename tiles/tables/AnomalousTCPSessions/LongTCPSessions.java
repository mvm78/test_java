package test_java.tiles.tables.AnomalousTCPSessions;

public class LongTCPSessions extends AnomalousTCPSessions {

    //**************************************************************************

    public LongTCPSessions() {

        this.setTitle("Long TCP Sessions");
        this.suffix = "pq 'dur > 60'";
    }

    //**************************************************************************

}