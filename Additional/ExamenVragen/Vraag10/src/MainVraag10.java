import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag10 extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyView view = new MyView();
        Scene scene = new Scene(view, 300,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vraag 10");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MyView extends Group {
    private Circle circle;
    private Path path;

    public MyView() {
        this.initialiseNodes();
        this.layoutNodes();
        this.animate();
    }

    private void initialiseNodes() {
        LineTo lineTo1 = new LineTo();
        lineTo1.setX(50);
        lineTo1.setY(50);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(250);
        lineTo2.setY(50);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(250);
        lineTo3.setY(250);

        LineTo lineTo4 = new LineTo();
        lineTo4.setX(50);
        lineTo4.setY(250);

        LineTo lineTo5 = new LineTo();
        lineTo5.setX(50);
        lineTo5.setY(50);

        this.circle = new Circle(10, Color.LIGHTCORAL);
        this.path = new Path();
        this.path.getElements().addAll(new MoveTo(50,50), lineTo1, lineTo2, lineTo3, lineTo4, lineTo5);
        this.path.setFill(null);
        this.path.setStrokeWidth(1);

    }

    private void layoutNodes() {
        this.getChildren().addAll(this.circle, this.path);
    }
    private void animate() {
        PathTransition transition = new PathTransition(Duration.seconds(4), this.path, this.circle);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
    }
}
