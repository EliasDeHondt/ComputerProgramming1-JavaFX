package be.kdg.dictee.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    }
    // Methode
    Button getBtnLeesVoor() { // Get..
        return this.btnLeesVoor;
    }
    TextArea getTxtDictee() {
        return this.txtDictee;
    }
}
