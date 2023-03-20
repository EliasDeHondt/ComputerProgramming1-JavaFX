package be.kdg.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SettingsView extends BorderPane {
    private Button saveButton;
    private TextField naamField;
    private TextField levelField;
    private ImageView imageView;

    public SettingsView() {
        initialiseControls();
        layoutControls();
    }

    private void initialiseControls() {
        saveButton = new Button("Save settings");
        naamField = new TextField();
        naamField.setMinWidth(20);
        levelField = new TextField();
        levelField.setMinWidth(5);
        imageView = new ImageView(new Image("/images/Mastermind.jpg"));
    }

    private void layoutControls() {
        this.setCenter(imageView);
        Label lblNaam = new Label("Naam:");
        lblNaam.setPrefWidth(40);
        Label lblLevel = new Label("Level:");
        lblLevel.setPrefWidth(40);
        HBox hBox = new HBox(lblNaam, naamField, lblLevel, levelField);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        VBox vBox = new VBox(hBox, saveButton);
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        this.setBottom(vBox);
        setPadding(new Insets(10));
    }

    Button getSaveButton() {
        return saveButton;
    }

    TextField getNaamField() {
        return naamField;
    }

    TextField getLevelField() {
        return levelField;
    }
}
