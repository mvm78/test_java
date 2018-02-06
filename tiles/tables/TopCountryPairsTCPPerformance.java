package test_java.tiles.tables;

import test_java.tiles.common.CommonTopCountryPairs;
import test_java.tiles.common.CommonByTCPBytes;

public class TopCountryPairsTCPPerformance extends Table {

    //**************************************************************************

    public TopCountryPairsTCPPerformance() {

        final CommonTopCountryPairs commonInstance = new CommonTopCountryPairs();
        final CommonByTCPBytes commonByInstance = new CommonByTCPBytes();

        this.setCommon(commonInstance);
        this.setCommonBy(commonByInstance);
        this.setIsSingleLine(true);
        this.setTitle("Top Country Pair TCP Performance");
        this.setPrefix("TcpAgg flowsegments");
        this.setCommonData();
    }

    //**************************************************************************

}