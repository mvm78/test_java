package test_java.tiles.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    public LinkedHashMap<String, Map<String, Object>> appendCompareColumns(
            final LinkedHashMap<String, Map<String, Object>> _columns,
            final int columnIncrement
    ) {

        final String[] noTallyColumns = this.getNoTallyColumns();

        final List noTally = Arrays.asList(noTallyColumns);
        final int start = _columns.size() + columnIncrement;

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