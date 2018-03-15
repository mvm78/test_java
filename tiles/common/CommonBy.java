package test_java.tiles.common;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;;
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

    public LinkedHashMap<String, ConcurrentHashMap<String, Object>> appendCompareColumns(
            final LinkedHashMap<String, ConcurrentHashMap<String, Object>> _columns,
            final int columnIncrement
    ) {

        final String[] noTallyColumns = this.getNoTallyColumns();

        final List noTally = Arrays.asList(noTallyColumns);
        final int start = _columns.size() + columnIncrement;

        AtomicInteger count = new AtomicInteger(start);

        this.getCompareColumns().forEach((column, value) -> {
            _columns.put(column, new ConcurrentHashMap<String, Object>() {{

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