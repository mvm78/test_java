package test_java.tiles.common;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class CommonBy {

    public abstract String getFields();
    public abstract LinkedHashMap<String, String> getCompareColumns();

    //**************************************************************************

    public String [] getNoTallyColumns() {

        return new String [] {};
    }

    //**************************************************************************

    public LinkedHashMap<String, HashMap<String, Object>> appendCompareColumns(
            LinkedHashMap<String, HashMap<String, Object>> _columns,
            int columnIncrement
    ) {

        List noTallyColumns = Arrays.asList(this.getNoTallyColumns());

        int start = _columns.size() + columnIncrement;

        AtomicInteger count = new AtomicInteger(start);

        this.getCompareColumns().forEach((column, value) -> {
            _columns.put(column, new HashMap<String, Object>() {{

                put("order", count.getAndAdd(1));
                put("compare", value);

                if (! noTallyColumns.contains(column)) {
                    put("tally", "true");
                }
            }});
        });

        return _columns;
    }

    //**************************************************************************

}