package test_java.tiles.tables.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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

        final CommonVLAN commonInstance = new CommonVLAN();
        final CommonByDatabaseLatencyAndSessions commonByInstance =
                new CommonByDatabaseLatencyAndSessions();

        this.setTitle("Database - Top VLAN");
        this.setPrefix("DbAgg");

        this.setCommonData(commonInstance, commonByInstance);
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(Map<String, Object> data) {

        Report report = (Report)data.get("report");

        data.put("columns", this.getColumns());

        String cmd = "/usr/local/mercury/bin/agg" +
                " i " + report.getIface() +
                report.getCmdTime() +
                " NetDist dst app_port src sport" +
                " q '" + Common.getRowFilter(data) + "'" +
                " w 0.0";

        AtomicReference<String> result = new AtomicReference<>("");

        try (BufferedReader results = this.getQueryResults(cmd)) {
            results.lines()
                    .filter(line -> {

                        String[] split = Util.split(line.trim(), this.getSplitChar());

                        return Util.getBufferLineFilter(split);
                    })
                    .forEach(line -> {

                        String[] split = Util.split(line.trim(), this.getSplitChar());

                        String filter = result.get().isEmpty() ? "" : " or ";

                        filter += "(host " + split[1] + " and port " + split[3] + " and" +
                                  " host " + split[2] + " and app_port " + split[4] + ")";

                        result.set(result.get() + filter);
                    });
        } catch (IOException e) {
            System.err.println(Consts.getBrightRed() + "Error reading query file");
            System.exit(1);
        }

        return result.toString();
    }

    //**************************************************************************

}