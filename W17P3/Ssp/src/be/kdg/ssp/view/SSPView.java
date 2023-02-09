package be.kdg.ssp.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SSPView extends VBox {
    public static final Color COUNTDOWN_COLOR = Color.RED;
    public static final Color STANDARD_COLOR = Color.BLACK;

    private Label textField;
    private Button playButton;


    public SSPView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.textField = new Label("Druk op start!");
        this.playButton = new Button("Start");
    }

    private void layoutNodes() {
        this.textField.setFont(new Font(36.0));
        this.textField.setTextFill(STANDARD_COLOR);
        this.playButton.setFont(new Font(24.0));
        this.setPadding(new Insets(50.0, 50.0, 50.0, 50.0));
        this.setSpacing(50.0);
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(textField);
        this.getChildren().add(playButton);
    }

    Label getTextField() {
        return textField;
    }

    Button getPlayButton() {
        return playButton;
    }
}
