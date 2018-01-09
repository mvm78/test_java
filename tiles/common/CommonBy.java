package test_java.tiles.common;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class CommonBy {

    public abstract String getFields();
    public abstract LinkedHashMap<String, String> getCompareColumns();
    public abstract String [] getNoTallyColumns();

    //**************************************************************************

    public LinkedHashMap<String, HashMap<String, Object>> appendCompareColumns(
            LinkedHashMap<String, HashMap<String, Object>> _columns,
            int columnIncrement
    ) {

        String [] noTallyColumns = this.getNoTallyColumns();

        int start = _columns.size() + columnIncrement;

        AtomicInteger count = new AtomicInteger(start);
        AtomicReference<LinkedHashMap<String, HashMap<String, Object>>> columnsRef =
                new AtomicReference<>(_columns);

        this.getCompareColumns().forEach((column, value) -> {
            _columns.put(column, new HashMap<String, Object>() {{

                put("order", count.getAndAdd(1));
                put("compare", value);

                if (! Arrays.asList(noTallyColumns).contains(column)) {
                    put("tally", "true");
                }
            }});
        });

        return _columns;
    }

    //**************************************************************************

}
