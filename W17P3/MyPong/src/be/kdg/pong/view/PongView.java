package be.kdg.pong.view;

import be.kdg.pong.model.Pong;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class PongView extends BorderPane {
    private Canvas canvas;
    private Button btnStart;
    private Label lblYouLost;

    public PongView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        canvas = new Canvas(Pong.FIELD_WIDTH, Pong.FIELD_HEIGHT);
        btnStart = new Button("Start");
        btnStart.setPrefWidth(100);
        lblYouLost = new Label("You lost! Score:");
        lblYouLost.setTextFill(Color.WHITE);
        lblYouLost.setVisible(false);
    }

    private void layoutNodes() {
        super.setCenter(new StackPane(canvas, lblYouLost));
        super.setBottom(btnStart);
        BorderPane.setAlignment(btnStart, Pos.CENTER);
        BorderPane.setMargin(btnStart, new Insets(10));
    }

    Canvas getCanvas() { // Get..
        return this.canvas;
    }
    Button getBtnStart() { // Get..
        return this.btnStart;
    }
    Label getLblYouLost() { // Get..
        return this.lblYouLost;
    }
}
