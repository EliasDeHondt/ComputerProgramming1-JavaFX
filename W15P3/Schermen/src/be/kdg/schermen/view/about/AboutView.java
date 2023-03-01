package be.kdg.schermen.view.about;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class AboutView extends BorderPane {
    private Button btnOK;

    public AboutView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        btnOK = new Button("Ok");
        btnOK.setPrefWidth(60);
    }

    private void layoutNodes() {
        setCenter(new Label("Deze applicatie is geschreven door Bassie en Adriaan."));
        setPadding(new Insets(10));
        BorderPane.setAlignment(btnOK, Pos.CENTER_RIGHT);
        BorderPane.setMargin(btnOK, new Insets(10, 0, 0, 0));
        setBottom(btnOK);
        this.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, null, null)));

    }

    Button getBtnOK() {
        return btnOK;
    }
}
