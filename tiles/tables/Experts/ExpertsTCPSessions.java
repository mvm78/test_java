package test_java.tiles.tables.Experts;

import test_java.tiles.tables.*;

public class ExpertsTCPSessions extends TCPConnections {

    //**************************************************************************

    public ExpertsTCPSessions() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setFilters(new String [] {"apptype http or port 80 or port 8080"});
    }

    //**************************************************************************

}
