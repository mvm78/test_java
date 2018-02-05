package test_java.tiles.tables;

import test_java.tiles.Tile;

public abstract class Table extends Tile {

    //**************************************************************************

    public Table() {

        this.setTileType("table");
    }

    //**************************************************************************

    protected final void setCommonData() {

        this.fields = this.getCommon().getFields().clone();
        String commonByFields = this.getCommonBy().getFields();

        for (int count=0; count<this.fields.length; count++) {
            this.fields[count] += " " + commonByFields;
        }

        this.filters = this.getCommon().getFilters();
        this.filterColumns = this.getCommon().getFilterColumns();
        this.columns = this.getCommonBy().appendCompareColumns(this.filterColumns,
                this.columnIncrement);
    }

    //**************************************************************************

}
