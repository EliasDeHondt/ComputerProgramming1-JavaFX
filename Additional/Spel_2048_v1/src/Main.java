import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static javafx.scene.input.KeyCode.*;

/**
 * @author Elias De Hondt
 * @since 25/03/2023
 */
public class Main extends Application {

    private static final int BOARD_SIZE = 4;
    private static final int TILE_SIZE = 100;
    private static final int SPACING = 10;
    private static final int FONT_SIZE = 40;
    private static final Color BACKGROUND_COLOR = Color.rgb(187, 173, 160);
    private static final Color TILE_COLOR = Color.rgb(204, 192, 179);
    private static final Color FONT_COLOR = Color.rgb(119, 110, 101);

    private int[][] board;
    private GridPane gridPane;
    private List<Pane> tilePanes;
    private Label scoreLabel;
    private int score;
    private boolean gameOver;
    private int size;
    private Tile[][] tiles;

    private Random random;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize board
        board = new int[BOARD_SIZE][BOARD_SIZE];
        random = new Random();
        tilePanes = new ArrayList<>();
        gameOver = false;

        // Create grid pane
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(SPACING);
        gridPane.setVgap(SPACING);
        gridPane.setStyle("-fx-background-color: #FF0000");

        size = 16; // ?
        tiles = new Tile[size][size];
        // initialiseer de tiles array met nieuwe Tile objecten
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                tiles[row][col] = new Tile();
            }
        }

        // Add tiles to grid pane
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Pane tilePane = createTilePane();
                tilePanes.add(tilePane);
                gridPane.add(tilePane, col, row);
            }
        }

        // Initialize score
        score = 0;
        scoreLabel = new Label("Score: " + score);
        scoreLabel.setFont(Font.font(FONT_SIZE));
        scoreLabel.setTextFill(FONT_COLOR);

        // Create scene
        Scene scene = new Scene(new StackPane(gridPane, scoreLabel));
        scene.setOnKeyPressed(this::handleKeyPressed);

        // Initialize board with two tiles
        addRandomTile();
        addRandomTile();

        // Show scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane createTilePane() {
        Pane tilePane = new Pane();
        Rectangle rectangle = new Rectangle(TILE_SIZE, TILE_SIZE, TILE_COLOR);
        rectangle.setArcWidth(10);
        rectangle.setArcHeight(10);
        Label label = new Label();
        label.setFont(Font.font(FONT_SIZE));
        label.setTextFill(FONT_COLOR);
        tilePane.getChildren().addAll(rectangle, label);
        return tilePane;
    }

    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == UP) {
            moveUp();
        } else if (event.getCode() == DOWN) {
            moveDown();
        }         else if (event.getCode() == LEFT) {
            moveLeft();
        } else if (event.getCode() == KeyCode.RIGHT) {
            moveRight();
        }

        // Check for game over
        if (isGameOver()) {
            gameOver();
        }

        // Add random tile
        addRandomTile();

        // Update score
        scoreLabel.setText("Score: " + score);
    }

    private void moveUp() {
        boolean moved = false;
        for (int col = 0; col < BOARD_SIZE; col++) {
            int[] column = getColumn(col);
            int[] merged = mergeTiles(column);
            setColumn(col, merged);
            if (!moved && !arrayEquals(column, merged)) {
                moved = true;
            }
        }
        if (moved) {
            score++;
        }
    }

    private void moveDown() {
        boolean moved = false;
        for (int col = 0; col < BOARD_SIZE; col++) {
            int[] column = getColumn(col);
            reverseArray(column);
            int[] merged = mergeTiles(column);
            reverseArray(merged);
            setColumn(col, merged);
            if (!moved && !arrayEquals(column, merged)) {
                moved = true;
            }
        }
        if (moved) {
            score++;
        }
    }

    private void moveLeft() {
        boolean moved = false;
        for (int row = 0; row < BOARD_SIZE; row++) {
            int[] rowArray = getRow(row);
            int[] merged = mergeTiles(rowArray);
            setRow(row, merged);
            if (!moved && !arrayEquals(rowArray, merged)) {
                moved = true;
            }
        }
        if (moved) {
            score++;
        }
    }

    private void moveRight() {
        boolean moved = false;
        for (int row = 0; row < BOARD_SIZE; row++) {
            int[] rowArray = getRow(row);
            reverseArray(rowArray);
            int[] merged = mergeTiles(rowArray);
            reverseArray(merged);
            setRow(row, merged);
            if (!moved && !arrayEquals(rowArray, merged)) {
                moved = true;
            }
        }
        if (moved) {
            score++;
        }
    }

    private int[] getColumn(int col) {
        int[] column = new int[BOARD_SIZE];
        for (int row = 0; row < BOARD_SIZE; row++) {
            column[row] = board[row][col];
        }
        return column;
    }

    private void setColumn(int col, int[] column) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            board[row][col] = column[row];
            updateTile(row, col);
        }
    }

    private int[] getRow(int row) {
        return board[row];
    }

    private void setRow(int row, int[] rowArray) {
        board[row] = rowArray;
        for (int col = 0; col < BOARD_SIZE; col++) {
            updateTile(row, col);
        }
    }
    private void addRandomTile() {
        if (isBoardFull()) {
            return;
        }
        int value = getRandomTileValue();
        int row, col;
        do {
            row = (int) (Math.random() * size);
            col = (int) (Math.random() * size);
        } while (tiles[row][col].getValue() != 0);
        tiles[row][col].setValue(value);
//        tiles[row][col].setColor(value);
    }


    private void gameOver() {
        gameOver = true;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("You lost!");
        alert.setContentText("Your score: " + score);
        alert.showAndWait();
    }
    private boolean isGameOver() {
        if (!isBoardFull()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Tile tile = tiles[i][j];
                if ((i < size - 1 && tile.getValue() == tiles[i + 1][j].getValue()) ||
                        (j < size - 1 && tile.getValue() == tiles[i][j + 1].getValue())) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean arrayEquals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    private void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
    private void updateTile(int row, int col) {
        int value = board[row][col];
        if (value == 0) {
            board[row][col] = 0;
            updateTileValueLabel(row, col);
            updateTileColor(row, col);
        } else {
            board[row][col] = value * 2;
            score += value * 2;
            updateTileValueLabel(row, col);
            updateTileColor(row, col);
            if (board[row][col] == 2048) {
                gameOver = true;
            }
        }
    }
    private void updateTileValueLabel(int row, int col) {
        Tile tile = tiles[row][col];
        tile.updateValueLabel();
    }

    private void updateTileColor(int row, int col) {
        Tile tile = tiles[row][col];
        tile.updateColor();
    }


    private boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tiles[i][j].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private int getRandomTileValue() {
        // 90% kans om 2 terug te geven, 10% kans om 4 terug te geven
        return Math.random() < 0.9 ? 2 : 4;
    }


    private int[] mergeTiles(int[] tiles) {
        int[] merged = new int[BOARD_SIZE];
        int index = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (tiles[i] != 0) {
                if (merged[index] == 0) {
                    merged[index] = tiles[i];
                } else if (merged[index] == tiles[i]) {
                    merged[index] *= 2;
                    score += merged[index];
                    index++;
                    merged[index] = tiles[i];
                }
            }

        }
        return merged;
    }

//        private void gameOver() {
//            // Display game over message
//            Label gameOverLabel = new Label("Game Over!");
//            gameOverLabel.setFont(Font.font("Arial", FontWeight.BOLD, 32));
//            gameOverLabel.setTextFill(Color.RED);
//            gameOverLabel.setAlignment(Pos.CENTER);
//            gameOverLabel.setPrefSize(TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE);
//            root.getChildren().add(gameOverLabel);
//            GridPane.setConstraints(gameOverLabel, 0, 0, BOARD_SIZE, BOARD_SIZE);
//
//            // Remove event handlers
//            root.setOnKeyPressed(null);
//
//            // Set game over flag
//            gameOver = true;
//        }
//
//            // Add two random tiles
//            addRandomTile();
//            addRandomTile();
//
//            // Reset score
//            score = 0;
//            updateScoreLabel();
//
//            // Reset game over flag
//            gameOver = false;
//
//            // Add event handler
//            root.setOnKeyPressed(event -> {
//                if (gameOver) {
//                    return;
//                }
//                boolean moved = switch (event.getCode()) {
//                    case UP -> moveUp();
//                    case DOWN -> moveDown();
//                    case LEFT -> moveLeft();
//                    case RIGHT -> moveRight();
//                    default -> false;
//                };
//                if (moved) {
//                    addRandomTile();
//                }
//                if (isGameOver()) {
//                    gameOver();
//                }
//            });
//        }

}

