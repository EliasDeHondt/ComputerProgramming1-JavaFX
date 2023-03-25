import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * @author Elias De Hondt
 * @since 25/03/2023
 */


public class Tile extends StackPane {

    private int value;
    private final Rectangle rectangle;
    private Label valueLabel;

    private static final int TILE_SIZE = 100;

    public Tile() {
        this(0);
    }

    public Tile(int value) {
        this.value = value;

        rectangle = new Rectangle(TILE_SIZE, TILE_SIZE);
        rectangle.setFill(Color.LIGHTGRAY);
        rectangle.setStroke(Color.GRAY);
        rectangle.setStrokeWidth(5);

        valueLabel = new Label(Integer.toString(value));
        valueLabel.setFont(new Font(48));
        valueLabel.setPrefWidth(TILE_SIZE - 10);
        valueLabel.setTextAlignment(TextAlignment.CENTER);
        valueLabel.setAlignment(Pos.CENTER);

        getChildren().addAll(rectangle, valueLabel);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void updateValueLabel() {
        valueLabel.setText(Integer.toString(value));
    }

    public void updateColor() {
        switch (value) {
            case 0 -> rectangle.setFill(Color.LIGHTGRAY);
            case 2 -> rectangle.setFill(Color.LIGHTYELLOW);
            case 4 -> rectangle.setFill(Color.YELLOW);
            case 8 -> rectangle.setFill(Color.ORANGE);
            case 16 -> rectangle.setFill(Color.DARKORANGE);
            case 32 -> rectangle.setFill(Color.ORANGERED);
            case 64 -> rectangle.setFill(Color.RED);
            case 128 -> rectangle.setFill(Color.LIGHTGREEN);
            case 256 -> rectangle.setFill(Color.GREEN);
            case 512 -> rectangle.setFill(Color.LIGHTBLUE);
            case 1024 -> rectangle.setFill(Color.BLUE);
            case 2048 -> rectangle.setFill(Color.PURPLE);
            default -> rectangle.setFill(Color.BLACK);
        }
    }

    public boolean equals(Tile other) {
        return this.value == other.value;
    }

    public String toString() {
        return Integer.toString(value);
    }

    public static int getTileSize() {
        return TILE_SIZE;
    }

}

