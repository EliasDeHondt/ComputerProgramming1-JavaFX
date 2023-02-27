package be.kdg.mypaint.view.about;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AboutView extends BorderPane {
    private Button btnOK;

    public AboutView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.btnOK = new Button("Ok");
        this.btnOK.setPrefWidth(60);
    }

    private void layoutNodes() {
        Label myLabel = new Label("Deze applicatie is geschreven door Bassie en Adriaan.");
        myLabel.setFont(new Font(20));
        setTop(myLabel);
        setCenter(new ImageView(new Image("myPaint.png")));
        setPadding(new Insets(10));
        BorderPane.setAlignment(btnOK, Pos.CENTER);
        BorderPane.setMargin(btnOK, new Insets(10));
        this.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(2))));
        setBottom(btnOK);
    }

    Button getBtnOK() {
        return this.btnOK;
    }
}
