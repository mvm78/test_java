package test_java.tiles.tables.AnomalousTCPSessions;

import test_java.tiles.tables.*;
import java.util.HashMap;
import test_java.tiles.common.CommonTCPSessions;

public class AnomalousTCPSessions extends Table {

    //**************************************************************************

    public AnomalousTCPSessions() {

        this.common = new CommonTCPSessions();

        this.isSingleLine = true;
        this.window = this.common.getWindow();
        this.prefix = this.common.getPrefix();
        this.fields = this.common.getFields();
        this.filters = this.common.getFilters();
        this.columns = this.common.getFilterColumns();
        this.lineTally = "Connections";
        this.removeFirstItem = true;
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(HashMap<String, Object> data) {

        data.put("columns", this.columns);

        return CommonTCPSessions.getRowFilter(data);
    }

    //**************************************************************************

}