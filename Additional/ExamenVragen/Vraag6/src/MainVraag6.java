import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag6 extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyView view = new MyView();
        primaryStage.setTitle("Vraag 6");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MyView extends BorderPane {
    private Canvas canvas;
    public MyView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.canvas = new Canvas(300, 300); //Hierna ontbreekt een regel
        GraphicsContext gc = this.canvas.getGraphicsContext2D();

        // CHARTREUSE
        gc.setFill(Color.CHARTREUSE);
        gc.beginPath();
        gc.moveTo(20,20);
        gc.lineTo(280,20);
        gc.lineTo(20,280);
        gc.closePath();
        gc.fill();

        // RED
        gc.setFill(Color.RED);
        gc.beginPath();
        gc.moveTo(280,280);
        gc.lineTo(20,280);
        gc.lineTo(280,20);
        gc.closePath();
        gc.fill();
    }

    private void layoutNodes() { //Plaats canvas in het center gedeelte
        this.setCenter(this.canvas);
    }
}
