package test_java.tiles.tables.Experts;

import test_java.tiles.tables.*;

public class ExpertsTopTCPServersByBytes extends TopTCPServersByBytes {

    //**************************************************************************

    public ExpertsTopTCPServersByBytes() {

        this.filters = new String [] {"apptype http or port 80 or port 8080"};
    }

    //**************************************************************************

}