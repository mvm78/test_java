package test_java.tiles.tables.AnomalousTCPSessions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;;

import test_java.tiles.tables.*;
import test_java.tiles.common.CommonTCPSessions;

public class AnomalousTCPSessions extends Table {

    //**************************************************************************

    public AnomalousTCPSessions() {

        final CommonTCPSessions commonInstance = new CommonTCPSessions();

        this.setCommon(commonInstance);
        this.setIsSingleLine(true);

        final String instancePrefix = this.getCommon().getPrefix();
        final String instanceWindow = this.getCommon().getWindow();
        final String[] instanceFields = this.getCommon().getFields();
        final String[] instanceFilters = this.getCommon().getFilters();
        final LinkedHashMap<String, ConcurrentHashMap<String, Object>> instanceColumns =
                this.getCommon().getFilterColumns();

        this.setPrefix(instancePrefix);
        this.setWindow(instanceWindow);
        this.setFields(instanceFields);
        this.setFilters(instanceFilters);
        this.setColumns(instanceColumns);
        this.setLineTally("Connections");
        this.setRemoveFirstItem(true);
    }

    //**************************************************************************

    @Override
    protected String getRowFilter(Map<String, Object> data) {

        data.put("columns", this.getColumns());

        return CommonTCPSessions.getRowFilter(data);
    }

    //**************************************************************************

}