import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class Vraag2 extends Group {
    private Circle circle;
    private Rectangle rectangle;

    public Vraag2() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        circle = new Circle(200, 80, 30, Color.ORANGE);
        rectangle = new Rectangle(60, 60, Color.CORNFLOWERBLUE);
        rectangle.setX(30);
        rectangle.setY(60);
    }

    private void layoutNodes() {
        getChildren().addAll(circle, rectangle); // Antwoord
    }
}

