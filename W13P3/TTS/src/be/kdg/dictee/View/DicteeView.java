package be.kdg.dictee.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

/**
 * Van Elias De Hondt
 * 6/02/2023
 */
public class DicteeView extends BorderPane {
    // Attributen
    private TextArea txtDictee;
    private Button btnLeesVoor;
    // Constructors
    public DicteeView() {
        txtDictee = new TextArea();
        btnLeesVoor = new Button("Lees Voor");
        this.setCenter(txtDictee);
        this.setBottom(btnLeesVoor);
        BorderPane.setAlignment(btnLeesVoor, Pos.CENTER);
        BorderPane.setMargin(btnLeesVoor, new Insets(10,10,10,10));
        // of BorderPane.setMargin(btnLeesVoor, new Insets(10));

        // Event
        btnLeesVoor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ik heb geen zin!");
                alert.setTitle("Dictee");
                alert.showAndWait();
            }
        });
        // of btnLeesVoor.setOnAction(new LeesVoorHandler());
    }
    // Methode
}
