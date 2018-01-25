package test_java.tiles.tables;

import test_java.tiles.common.CommonTopCountryPairs;
import test_java.tiles.common.CommonByTCPBytes;

public class TopCountryPairsTCPPerformance extends Table {

    //**************************************************************************

    public TopCountryPairsTCPPerformance() {

        this.common = new CommonTopCountryPairs();
        this.commonBy = new CommonByTCPBytes();

        this.isSingleLine = true;
        this.title = "Top Country Pair TCP Performance";
        this.prefix = "TcpAgg flowsegments";
        this.setCommonData();
    }

    //**************************************************************************

}