package examples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DISCLAIMER: hier wordt geen MVP gebruikt!
 * Alles quick and dirty in deze klasse; puur om het gebruik van kant-en-klare dialoogvensters te demonstreren
 */
public class Dialogs extends Application {

    @Override
    public void start(Stage stage) {
        Scene mainScene = createMainScene();
        stage.setScene(mainScene);
        stage.show();
    }

    private Scene createMainScene() {
        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-background-color: darkcyan; -fx-padding: 10;");
        vbox.setAlignment(Pos.CENTER);

        Button button = new Button("Click Me.");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAlert();
                showCustomDialog();
                showTextInputDialog();
                showChoiceDialog();
                showCustomLoginDialog();
            }
        });
        vbox.getChildren().add(button);

        Scene scene = new Scene(vbox, 500, 300);
        return scene;
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);       // Er zijn nog andere alerttypes.
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("We looove Java!");

        alert.showAndWait();
    }

    private void showCustomDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with Custom Actions");
        alert.setHeaderText("Look, a Confirmation Dialog with Custom Actions");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("One");
        ButtonType buttonTypeTwo = new ButtonType("Two");
        ButtonType buttonTypeThree = new ButtonType("Three");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

        Optional<ButtonType> clickResult = alert.showAndWait();

        if (clickResult.get() == buttonTypeOne) {
            System.out.println("You clicked button 1.");
        } else if (clickResult.get() == buttonTypeTwo) {
            System.out.println("You clicked button 2.");
        } else if (clickResult.get() == buttonTypeThree) {
            System.out.println("You clicked button 3.");
        } else {
            System.out.println("You clicked the cancel button.");
        }
    }

    private void showTextInputDialog() {
        TextInputDialog dialog = new TextInputDialog("Programming");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your favourite hobby:");

        // Get the response value.
        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            System.out.println("Your hobby: " + result.get());
        }
    }

    private void showChoiceDialog() {
        List<String> choices = new ArrayList<String>();
        choices.add("Viva Collection Blender");
        choices.add("Daily Collection Blender");
        choices.add("Avance Collection Blender");

        ChoiceDialog<String> dialog = new ChoiceDialog<String>("Viva Collection Blender", choices);
        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Look, a Choice Dialog");
        dialog.setContentText("Choose your Philips blender:");

        // Get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Your choice: " + result.get());
        }
    }

    private void showCustomLoginDialog() {
        // Create the custom dialog.
        Dialog dialog = new Dialog();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Look, a Custom Login Dialog");

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

        dialog.getDialogPane().setContent(grid);

        Optional<Pair<String, String>> result = dialog.showAndWait();

        // Validate input here.
        if (result.isPresent()) {
            System.out.println("Username=" + username.getText() + ", Password=" + password.getText());
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
