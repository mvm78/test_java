package test_java.tiles.tables;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import test_java.tiles.common.Common;
import test_java.tiles.common.CommonTCPSessions;

public class TCPConnections extends Table {

    //**************************************************************************

    public TCPConnections() {

        final CommonTCPSessions CommonInstance = new CommonTCPSessions();

        this.setCommon(CommonInstance);
        this.setTitle("TCP Connections");

        final String instancePrefix = this.getCommon().getPrefix();
        final String instanceWindow = this.getCommon().getWindow();
        final LinkedHashMap<String, HashMap<String, Object>> instanceColumns =
                this.getCommon().getFilterColumns();

        this.setPrefix(instancePrefix);
        this.setWindow(instanceWindow);
        this.setFields(new String [] {
            "tcpflags pcid"
        });
        this.setFilters();
        this.setColumns(instanceColumns);
        this.setRemoveFirstItem(true);
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(Map<String, Object> data) {

        data.put("columns", this.getColumns());

        return Common.getRowFilter(data);
    }

    //**************************************************************************

}
