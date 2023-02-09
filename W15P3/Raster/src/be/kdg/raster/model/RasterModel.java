package be.kdg.raster.model;

public class RasterModel {
    private static final int DEFAULT_ROWS = 10;
    private static final int DEFAULT_COLUMNS = 10;

    private int rows;
    private int columns;

    public RasterModel() {
        this.rows = DEFAULT_ROWS;
        this.columns = DEFAULT_COLUMNS;
    }

    public RasterModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
