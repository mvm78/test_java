package test_java.tiles.common;

import java.util.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

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

    public String[] getFields() {

        return new String[] {""};
    }

    //**************************************************************************

    final public String getField(int index) {

        return this.getFields()[index];
    }

    //**************************************************************************

    public String[] getFilters() {

        return new String[] {};
    }

    //**************************************************************************

    public String getCommonRowFilter(Map<String, Object> data) {

        data.put("columns", this.getFilterColumns());

        return Common.getRowFilter(data);
    }

    //**************************************************************************

    @SuppressWarnings("unchecked")
    public static String getRowFilter(Map<String, Object> data) {

        final AtomicReference<Map<String, HashMap<String, Object>>> columns =
                new AtomicReference<>((Map)((LinkedHashMap)data.get("columns")).clone());
        final String filterColumn = (String)data.get("filterColumn");
        final String value = (String)data.get("value");
        final int count = (int)data.get("filterCount");
        final int cellDrill = (int)data.get("cellDrill");

        final AtomicReference<Map<String, Object>> column =
                new AtomicReference<>((Map)columns.get().get(filterColumn));

        String escaped;

        if (column.get().get("valueFunction") == null) {

            escaped = column.get().get("escapeDoubleQuote") != null
                  && (boolean)column.get().get("escapeDoubleQuote") ?
                    value.replace("\"", "\\\"") : value;

            escaped = column.get().get("escapeSingleQuote") != null
                  && (boolean)column.get().get("escapeSingleQuote") ?
                    escaped.replace("\'", "\\\'") : escaped;

        } else {

            final String valueFunction = (String)column.get().get("valueFunction");

            try {

                final Method method = Class.forName("test_java.common.Util")
                        .getDeclaredMethod(valueFunction, String.class);

                escaped = (String)method.invoke(null, value);

            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                return null;
            }
        }

        final String[] cellDrillInfo = (String[])column.get().get("cellDrill");

        final String type = cellDrill > 0 && cellDrillInfo.length > 0 ?
                "cellDrill" : "filter";

        final String[] filters = (String[])column.get().get(type);

        return filters[count].replace("{{value}}", escaped);
    }

    //**************************************************************************

}