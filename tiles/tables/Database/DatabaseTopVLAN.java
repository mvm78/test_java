package test_java.tiles.tables.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import test_java.common.Consts;
import test_java.common.Util;
import test_java.reports.Report;
import test_java.tiles.common.Common;
import test_java.tiles.tables.Table;
import test_java.tiles.common.CommonVLAN;
import test_java.tiles.common.CommonByDatabaseLatencyAndSessions;

public class DatabaseTopVLAN extends Table {

    //**************************************************************************

    public DatabaseTopVLAN() {

        this.common = new CommonVLAN();
        this.commonBy = new CommonByDatabaseLatencyAndSessions();

        this.title = "Database - Top VLAN";
        this.prefix = "DbAgg";
        this.fields = new String [] {
            this.common.getFields()[0] + " " + this.commonBy.getFields(),
        };
        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns, 1);
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(HashMap<String, Object> data) {

        Report report = (Report)data.get("report");

        data.put("columns", this.columns);

        String line;
        String result = "";
        String cmd = "/usr/local/mercury/bin/agg" +
                report.getCmdAppliance() +
                report.getCmdTime() +
                " NetDist dst app_port src sport" +
                " q '" + Common.getRowFilter(data) + "'" +
                " w 0.0";

        BufferedReader results = this.getQueryResults(cmd);

        try {
            while ((line = results.readLine()) != null) {

                line = line.trim();

                String [] split = Util.split(line, " ");

                if (split[0].equals("#I;") || split[0].equals("window")) {
                    continue;
                }

                result += result.isEmpty() ? "" : " or ";
                result += "(host " + split[1] + " and port " + split[3] +
                        " and host " + split[2] + " and app_port " + split[4] + ")";
            }
        } catch (IOException e) {
            System.err.println(Consts.BRIGHT_RED + "Error reading query file");
            System.exit(1);
        }

        return result;
    }

    //**************************************************************************

}