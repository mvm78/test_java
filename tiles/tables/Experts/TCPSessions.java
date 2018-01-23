package test_java.tiles.tables.Experts;

import test_java.tiles.tables.*;
import java.util.HashMap;
import test_java.tiles.common.Common;
import test_java.tiles.common.CommonTCPSessions;

public class TCPSessions extends Table {

    //**************************************************************************

    public TCPSessions() {

        this.common = new CommonTCPSessions();

        this.appPath = "/usr/local/mercury/bin/agg";
        this.isSingleLine = true;
        this.title = "TCP Sessions";
        this.window = this.common.getWindow();
        this.prefix = this.common.getPrefix();
        this.fields = new String [] {
            "tcpflags pcid"
        };
        this.filters = new String [] {"apptype http or port 80 or port 8080"};
        this.columns = this.common.getFilterColumns();
        this.removeFirstItem = true;
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(HashMap<String, Object> data) {

        data.put("columns", this.columns);

        return Common.getRowFilter(data);
    }

    //**************************************************************************

}
