package be.kdg.mywoordle.view;

import be.kdg.mywoordle.model.Woordle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Hoofd-viewklasse
 */
public class WoordleView extends BorderPane {
    private WoordleRow[] woordleRows;
    private TextField txtInput;
    private Button btnBevestig;
    private Label lblBeurt;

    public WoordleView() {
        initControls();
        layoutControls();
    }

    private void initControls() {
        woordleRows = new WoordleRow[Woordle.AANTAL_BEURTEN];
        txtInput = new TextField();
        txtInput.setPrefColumnCount(9);
        btnBevestig = new Button("Bevestig");
        lblBeurt = new Label("Beurt 1:");
    }

    private void layoutControls() {
        VBox vbox = new VBox();
        for(int i = 0; i < Woordle.AANTAL_BEURTEN; i++) {
            woordleRows[i] = new WoordleRow();
            vbox.getChildren().add(woordleRows[i]);
        }
        vbox.setSpacing(6);
        vbox.setPadding(new Insets(6));
        setCenter(vbox);

        HBox hBox = new HBox(lblBeurt, txtInput, btnBevestig);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));
        lblBeurt.setPadding(new Insets(5));
        setBottom(hBox);

        super.setPadding(new Insets(10));
    }

    WoordleRow[] getWoordleRows() {
        return woordleRows;
    }

    TextField getTxtInput() {
        return txtInput;
    }

    Button getBtnBevestig() {
        return btnBevestig;
    }

    Label getLblBeurt() {
        return lblBeurt;
    }
}
