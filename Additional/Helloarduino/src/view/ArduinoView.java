package be.kdg.helloarduino.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ArduinoView extends BorderPane {
    private Button btnSend;
    private TextField tfTextForArduino;
    private TextField tfTextFromArduino;

    public ArduinoView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        btnSend = new Button("Send to Arduino!");
        tfTextForArduino = new TextField();
        tfTextForArduino.setMinWidth(100);
        tfTextFromArduino = new TextField();
        tfTextFromArduino.setEditable(false);
        tfTextFromArduino.setMinWidth(100);
    }

    private void layoutNodes() {
        Label lblEnterNumber = new Label("Enter string:");
        VBox topBox = new VBox(lblEnterNumber, tfTextForArduino, tfTextFromArduino);
        topBox.setSpacing(10);
        topBox.setPadding(new Insets(10));
        super.setTop(topBox);
        VBox bottomBox = new VBox(btnSend);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(10));
        super.setBottom(bottomBox);
        super.setPadding(new Insets(10));
    }

    Button getBtnSend() {
        return btnSend;
    }

    TextField getTfTextForArduino() {
        return tfTextForArduino;
    }

    TextField getTfTextFromArduino() {
        return tfTextFromArduino;
    }
}
