package be.kdg.tegels.model;

public class TileModel {
    public static final int COLUMNS = 4;
    public static final int ROWS = 3;

    private int selectedTileColumn;
    private int selectedTileRow;

    public TileModel() {
        this.selectedTileColumn = -1;
        this.selectedTileRow = -1;
    }

    public void setSelectedTile(int column, int row) {
        if (this.selectedTileColumn == column && this.selectedTileRow == row) {
            this.selectedTileColumn = -1;
            this.selectedTileRow = -1;
        }
        else {
            this.selectedTileColumn = column;
            this.selectedTileRow = row;
        }
    }

    public int getSelectedTileColumn() {
        return this.selectedTileColumn;
    }

    public int getSelectedTileRow() {
        return this.selectedTileRow;
    }
}
