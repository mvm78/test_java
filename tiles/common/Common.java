package test_java.tiles.common;

import java.util.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public abstract class Common {

    protected String window = "0.0";
    protected String prefix;

    public abstract LinkedHashMap<String, HashMap<String, Object>> getFilterColumns();

    //**************************************************************************

    final public String getWindow() {

        return this.window;
    }

    //**************************************************************************

    final public void setWindow(String window) {

        this.window = window;
    }

    //**************************************************************************

    final public String getPrefix() {

        return this.prefix;
    }

    //**************************************************************************

    final public void setPrefix(String prefix) {

        this.prefix = prefix;
    }

    //**************************************************************************

    public String [] getFields() {

        return new String [] {""};
    }

    //**************************************************************************

    public String [] getFilters() {

        return new String [] {};
    }

    //**************************************************************************

    public String getCommonRowFilter(Map<String, Object> data) {

        data.put("columns", this.getFilterColumns());

        return Common.getRowFilter(data);
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static String getRowFilter(Map<String, Object> data) {

        Map<String, HashMap<String, Object>> columns =
                (Map<String, HashMap<String, Object>>)((LinkedHashMap<String, HashMap<String, Object>>)data.get("columns")).clone();
        String filterColumn = (String)data.get("filterColumn");
        String value = (String)data.get("value");
        int count = (int)data.get("filterCount");
        int cellDrill = (int)data.get("cellDrill");

        Map<String, Object> column = (HashMap<String, Object>)columns.get(filterColumn);

        String escaped;

        if (column.get("valueFunction") != null) {

            String valueFunction = (String)column.get("valueFunction");

            try {

                Method method = Class.forName("test_java.common.Util")
                        .getDeclaredMethod(valueFunction, String.class);

                escaped = (String)method.invoke(null, value);

            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                return null;
            }
        } else {

            escaped = column.get("escapeDoubleQuote") != null
                          && (boolean)column.get("escapeDoubleQuote") ?
                    value.replace("\"", "\\\"") : value;

            escaped = column.get("escapeSingleQuote") != null
                          && (boolean)column.get("escapeSingleQuote") ?
                    escaped.replace("\'", "\\\'") : escaped;
        }

        String type = cellDrill > 0 && ((String [])column.get("cellDrill")).length > 0 ?
                "cellDrill" : "filter";

        String [] filters = (String [])column.get(type);

        return filters[count].replace("{{value}}", escaped);
    }

    //**************************************************************************

}