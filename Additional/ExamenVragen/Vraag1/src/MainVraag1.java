import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyView view = new MyView();
        Scene scene = new Scene(view);
        primaryStage.setTitle("Vraag 1");
        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

class MyView extends Group {
    private Circle circle;
    private Rectangle rectangle;

    public MyView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.circle = new Circle(200, 80, 30, Color.ORANGE);
        this.rectangle = new Rectangle(60, 60, Color.CORNFLOWERBLUE);
        this.rectangle.setX(30);
        this.rectangle.setY(60);
    }

    private void layoutNodes() {
        getChildren().addAll(this.circle, this.rectangle);
    }
}

