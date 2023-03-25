import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag9 extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyView view = new MyView();
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Vraag 9");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MyView extends BorderPane {
    private static final int COUNT = 10;
    private static final int RADIUS = 10;
    private Canvas canvas;
    private Color base = Color.BLACK;
    private Color alternate = new Color(1.0, 1.0, 1.0, 1.0);

    public MyView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.canvas = new Canvas(300, 300);
        GraphicsContext gc = this.canvas.getGraphicsContext2D();

        double centerX = this.canvas.getWidth() / 2;
        double centerY = this.canvas.getHeight() / 2;

        for (int i = COUNT; i > 0; i--) {
            if (i % 2 == 0) {
                gc.setFill(base);
            } else {
                gc.setFill(alternate);
            }

            gc.fillOval(centerX - i * RADIUS, centerY - i * RADIUS, i * 2 * RADIUS, i * 2 * RADIUS);
        }

    }

    private void layoutNodes() { // Vul hieronder de ontbrekende regel in
        this.setCenter(this.canvas);


    }
}
