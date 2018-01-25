package test_java.tiles.tables;

import test_java.tiles.Tile;

public abstract class Table extends Tile {

    //**************************************************************************

    public Table() {

        this.tileType = "table";
    }

    //**************************************************************************

    @Override
    public void setWindow(float timeInterval) {

        this.window = this.window == null ? "0.0" : this.window;
    }

    //**************************************************************************

    protected final void setCommonData() {

        this.fields = this.common.getFields().clone();
        String commonByFields = this.commonBy.getFields();

        for (int count=0; count<this.fields.length; count++) {
            this.fields[count] += " " + commonByFields;
        }

        this.filters = this.common.getFilters();
        this.filterColumns = this.common.getFilterColumns();
        this.columns = this.commonBy.appendCompareColumns(this.filterColumns,
                this.columnIncrement);
    }

    //**************************************************************************

}
