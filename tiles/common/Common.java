package test_java.tiles.common;

import java.util.HashMap;
import java.util.*;

public abstract class Common {

    protected boolean checkNot = true;

    public abstract String [] getFields();
    public abstract LinkedHashMap<String, HashMap<String, Object>> getFilterColumns();

    //**************************************************************************

    public boolean getCheckNot() {

        return this.checkNot;
    }

    //**************************************************************************

    public String [] getFilters() {

        return new String [] {};
    }

    //**************************************************************************

    public String getCommonRowFilter(HashMap<String, Object> data) {

        data.put("columns", this.getFilterColumns());

        return Common.getRowFilter(data);
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static String getRowFilter(HashMap<String, Object> data) {

        Map<String, HashMap<String, Object>> columns =
                (Map<String, HashMap<String, Object>>)((LinkedHashMap<String, HashMap<String, Object>>)data.get("columns")).clone();
        String filterColumn = (String)data.get("filterColumn");
        String value = (String)data.get("value");
        int count = (int)data.get("filterCount");
        int cellDrill = (int)data.get("cellDrill");

        Map<String, Object> column = (HashMap<String, Object>)columns.get(filterColumn);

        String escaped = column.get("escapeQuote") != null && (boolean)column.get("escapeQuote") ?
                value.replace("\"", "\\\"") : value;
        String type = cellDrill > 0 && ((String [])column.get("cellDrill")).length > 0 ?
                "cellDrill" : "filter";

        String [] filters = (String [])column.get(type);

        return filters[count].replace("{{value}}", escaped);
    }

    //**************************************************************************

}