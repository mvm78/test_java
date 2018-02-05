package test_java.tiles.tables;

import test_java.tiles.common.CommonTopCountryPairs;
import test_java.tiles.common.CommonByTCPBytes;

public class TopCountryPairsTCPPerformance extends Table {

    //**************************************************************************

    public TopCountryPairsTCPPerformance() {

        final CommonTopCountryPairs CommonInstance = new CommonTopCountryPairs();
        final CommonByTCPBytes CommonByInstance = new CommonByTCPBytes();

        this.setCommon(CommonInstance);
        this.setCommonBy(CommonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Country Pair TCP Performance");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}