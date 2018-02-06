package test_java.tiles.tables;

import java.util.HashMap;
import java.util.LinkedHashMap;
import test_java.tiles.Tile;

public abstract class Table extends Tile {

    //**************************************************************************

    public Table() {

        this.setTileType("table");
    }

    //**************************************************************************

    @Override
    public void setWindow(float window) {

        this.setWindow(this.getWindow() == null ? "0.0" : this.getWindow());
    }

    //**************************************************************************

    protected final void setCommonData() {

        final String [] instanceFields = this.getCommon().getFields().clone();
        final String commonByFields = this.getCommonBy().getFields();
        final String [] instanceFilters = this.getCommon().getFilters();
        final LinkedHashMap<String, HashMap<String, Object>> instanceFilterColumns =
                this.getCommon().getFilterColumns();
        final LinkedHashMap<String, HashMap<String, Object>> instanceColumns =
                this.getCommonBy().appendCompareColumns(instanceFilterColumns,
                        this.getColumnIncrement());

        this.setFields(instanceFields);
        for (int count=0; count<this.getFields().length; count++) {
            this.setField(count, this.getField(count) + " " + commonByFields);
        }
        this.setFilters(instanceFilters);
        this.setFilterColumns(instanceFilterColumns);
        this.setColumns(instanceColumns);
    }

    //**************************************************************************

}
