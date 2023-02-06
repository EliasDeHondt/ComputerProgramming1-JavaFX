package be.kdg.dictee.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 * Van Elias De Hondt
 * 6/02/2023
 */
public class LeesVoorHandler implements EventHandler<ActionEvent> {
    // Attributes
    // Constructors
    // Methods
    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Ik heb geen zin!");
        alert.setTitle("Dictee");
        alert.showAndWait();
    }
}
