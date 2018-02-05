package test_java.tiles.tables.AnomalousTCPSessions;

import test_java.tiles.tables.*;
import java.util.Map;
import test_java.tiles.common.CommonTCPSessions;

public class AnomalousTCPSessions extends Table {

    //**************************************************************************

    public AnomalousTCPSessions() {

        this.common = new CommonTCPSessions();

        this.setIsSingleLine(true);
        this.window = this.getCommon().getWindow();
        this.prefix = this.getCommon().getPrefix();
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