package test_java.tiles.common;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class CommonBy {

    public abstract String getFields();
    public abstract LinkedHashMap<String, String> getCompareColumns();

    //**************************************************************************

    public String[] getNoTallyColumns() {

        return new String[] {};
    }

    //**************************************************************************

    public LinkedHashMap<String, HashMap<String, Object>> appendCompareColumns(
            LinkedHashMap<String, HashMap<String, Object>> _columns,
            int columnIncrement
    ) {

        String[] noTallyColumns = this.getNoTallyColumns();

        List noTally = Arrays.asList(noTallyColumns);

        int start = _columns.size() + columnIncrement;

        AtomicInteger count = new AtomicInteger(start);

        this.getCompareColumns().forEach((column, value) -> {
            _columns.put(column, new HashMap<String, Object>() {{

                put("order", count.getAndAdd(1));
                put("compare", value);

                if (! noTally.contains(column)) {
                    put("tally", "true");
                }
            }});
        });

        return _columns;
    }

    //**************************************************************************

}