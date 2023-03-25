import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag3 extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyView view = new MyView();
        primaryStage.setTitle("Vraag 3");
        primaryStage.setScene(new Scene(view));
        primaryStage.setHeight(100);
        primaryStage.setWidth(300);
        primaryStage.show();

        // Get the selected radio button
        RadioButton selectedButton = view.getSelectedButton();
        System.out.println("Selected button: " + selectedButton.getText());

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
class MyView extends HBox {
    private static final String[] maten = { "XS", "S", "M", "XL", "XXL" };
    private RadioButton[] buttons;
    private RadioButton selectedButton;

    public MyView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.buttons = new RadioButton[maten.length];
        ToggleGroup group = new ToggleGroup();
        for (int i = 0; i < maten.length; i++) {
            this.buttons[i] = new RadioButton(maten[i]);
            this.buttons[i].setToggleGroup(group);
            if (i == 2) { // Select the middle button by default
                this.buttons[i].setSelected(true);
                this.selectedButton = this.buttons[i];
            }
            this.buttons[i].setOnMouseClicked(event -> this.selectedButton = (RadioButton) event.getSource());
        }
    }

    private void layoutNodes() {
        this.setPadding(new Insets(10));
        this.setSpacing(20);
        this.getChildren().addAll(this.buttons);
    }

    public RadioButton getSelectedButton() {
        return this.selectedButton;
    }
}