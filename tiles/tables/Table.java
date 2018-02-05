package test_java.tiles.tables;

import test_java.tiles.Tile;

public abstract class Table extends Tile {

    //**************************************************************************

    public Table() {

        this.setTileType("table");
    }

    //**************************************************************************

    protected final void setCommonData() {

        final String [] instanceFields = this.getCommon().getFields().clone();
        final String commonByFields = this.getCommonBy().getFields();
        final String [] instanceFilters = this.getCommon().getFilters();

        this.setFields(instanceFields);
        for (int count=0; count<this.getFields().length; count++) {
            this.setField(count, this.getField(count) + " " + commonByFields);
        }
        this.setFilters(instanceFilters);
        this.filterColumns = this.getCommon().getFilterColumns();
        this.columns = this.getCommonBy().appendCompareColumns(this.filterColumns,
                this.columnIncrement);
    }

    //**************************************************************************

}
