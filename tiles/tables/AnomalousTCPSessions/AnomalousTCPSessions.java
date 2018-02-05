package test_java.tiles.tables.AnomalousTCPSessions;

import java.util.Map;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTCPSessions;

public class AnomalousTCPSessions extends Table {

    //**************************************************************************

    public AnomalousTCPSessions() {

        final CommonTCPSessions CommonInstance = new CommonTCPSessions();

        this.setCommon(CommonInstance);
        this.setIsSingleLine(true);
        this.window = this.getCommon().getWindow();

        final String instancePrefix = this.getCommon().getPrefix();

        this.setPrefix(instancePrefix);
        this.fields = this.getCommon().getFields();
        this.filters = this.getCommon().getFilters();
        this.columns = this.getCommon().getFilterColumns();
        this.lineTally = "Connections";
        this.removeFirstItem = true;
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(Map<String, Object> data) {

        data.put("columns", this.columns);

        return CommonTCPSessions.getRowFilter(data);
    }

    //**************************************************************************

}