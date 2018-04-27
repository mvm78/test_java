package test_java.tiles.tables;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;

import test_java.tiles.Tile;
import test_java.tiles.common.Common;
import test_java.tiles.common.CommonBy;

public abstract class Table extends Tile {

    //**************************************************************************

    public Table() {

        this.setTileType("table");
    }

    //**************************************************************************

    @Override
    public void setWindow(final float window) {

        this.setWindow(this.getWindow() == null ? "0.0" : this.getWindow());
    }

    //**************************************************************************

    protected final <T1 extends Common, T2 extends CommonBy> void setCommonData(
            final T1 common, final T2 commonBy
    ) {

        this.setCommon(common);
        this.setCommonBy(commonBy);

        final String[] instanceFields = common.getFields().clone();
        final String commonByFields = commonBy.getFields();
        final String[] instanceFilters = common.getFilters();
        final LinkedHashMap<String, Map<String, Object>> instanceFilterColumns =
                common.getFilterColumns();
        final LinkedHashMap<String, Map<String, Object>> instanceColumns =
                commonBy.appendCompareColumns(instanceFilterColumns, this.getColumnIncrement());

        this.setFields(instanceFields);

        IntStream.range(0, this.getFields().length).parallel()
                .forEach(count -> this.setField(count, this.getField(count) + " " + commonByFields));

        this.setFilters(instanceFilters);
        this.setFilterColumns(instanceFilterColumns);
        this.setColumns(instanceColumns);
    }

    //**************************************************************************

}