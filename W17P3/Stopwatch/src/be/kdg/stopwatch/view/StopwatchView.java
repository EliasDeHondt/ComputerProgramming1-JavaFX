package be.kdg.stopwatch.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class StopwatchView extends GridPane {
    private Label lblHours;
    private Label lblMinutes;
    private Label lblSeconds;
    private Button btnStart;
    private Button btnPause;
    private Button btnStop;
    private Font giantFont;

    public StopwatchView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.giantFont = new Font("Arial", 96);
        this.lblHours = new Label();
        this.lblHours.setFont(giantFont);
        this.lblMinutes = new Label();
        this.lblMinutes.setFont(giantFont);
        this.lblSeconds = new Label();
        this.lblSeconds.setFont(giantFont);
        this.btnStart = new Button("Start");
        this.btnPause = new Button("Pauze");
        this.btnStop = new Button("Stop");
    }

    private void layoutNodes() {
        //this.setGridLinesVisible(true);
        this.add(this.lblHours, 0, 0);
        Label lblFirstColon = new Label(":");
        lblFirstColon.setFont(giantFont);
        this.add(lblFirstColon, 1, 0);
        this.add(this.lblMinutes, 2, 0);
        Label lblSecondColon = new Label(":");
        lblSecondColon.setFont(giantFont);
        this.add(lblSecondColon, 3, 0);
        this.add(this.lblSeconds, 4, 0);
        this.add(this.btnStart, 0, 1);
        this.add(this.btnPause, 2, 1);
        this.add(this.btnStop, 4, 1);

        this.setPadding(new Insets(10));
        GridPane.setHalignment(this.btnStart, HPos.CENTER);
        GridPane.setHalignment(this.btnPause, HPos.CENTER);
        GridPane.setHalignment(this.btnStop, HPos.CENTER);

        this.setStyle("-fx-background-color: lightblue");
    }

    Label getLblHours() {
        return lblHours;
    }

    Label getLblMinutes() {
        return lblMinutes;
    }

    Label getLblSeconds() {
        return lblSeconds;
    }

    Button getBtnStart() {
        return btnStart;
    }

    Button getBtnPause() {
        return btnPause;
    }

    Button getBtnStop() {
        return btnStop;
    }
}
