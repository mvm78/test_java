package test_java.tiles.tables;

import java.util.Map;

import test_java.tiles.common.Common;
import test_java.tiles.common.CommonTCPSessions;

public class TCPConnections extends Table {

    //**************************************************************************

    public TCPConnections() {

        CommonTCPSessions CommonInstance = new CommonTCPSessions();

        this.setCommon(CommonInstance);
        this.title = "TCP Connections";
        this.window = this.getCommon().getWindow();
        this.prefix = this.getCommon().getPrefix();
        this.fields = new String [] {
            "tcpflags pcid"
        };
        this.filters = new String [] {};
        this.columns = this.getCommon().getFilterColumns();
        this.removeFirstItem = true;
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(Map<String, Object> data) {

        data.put("columns", this.columns);

        return Common.getRowFilter(data);
    }

    //**************************************************************************

}
