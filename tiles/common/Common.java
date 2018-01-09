package test_java.tiles.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Base64;

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

    public static String getRowFilter(HashMap<String, Object> data) {

        LinkedHashMap<String, HashMap<String, Object>> columns =
                (LinkedHashMap<String, HashMap<String, Object>>)data.get("columns");
        String filterColumn = (String)data.get("filterColumn");
        String value = (String)data.get("value");
        int filterCount = (int)data.get("filterCount");
        int singleDrill = (int)data.get("singleDrill");

        AtomicReference<String> rowFilter = new AtomicReference<>("");

        String type = singleDrill > 0 ? "singleDrill" : "filter";

        columns.forEach((key, info) -> {

            Object filter = info.get(type);

            if (filter == null) {
                return;
            }

            if (key.equals(filterColumn)) {

                String [] filters = (String [])info.get(type);

                String escaped = value.replace("\"", "\\\"");

                String expression = filters[filterCount].replace("{{value}}", escaped);

                rowFilter.set(expression);
            }
        });

        return rowFilter.toString();
    }

    //**************************************************************************

}