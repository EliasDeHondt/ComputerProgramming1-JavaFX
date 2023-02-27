package graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.*;
import javafx.scene.text.Font;

import javax.swing.text.BadLocationException;

public class Painting extends BorderPane {
    private Canvas canvas;

    public Painting() {
        this.initialiseerNodes();
        this.layoutNodes();
        this.maakTekening();
    }

    private void initialiseerNodes() {
        this.canvas = new Canvas(500, 500);
    }

    private void layoutNodes() {
        this.setWidth(500);
        this.setHeight(500);
        this.setCenter(canvas);
    }

    private void maakTekening() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
//        gc.setStroke(Color.hsb(0.8, 0.3, 0.9));
//        gc.setFill(Color.rgb(30, 230, 80, 0.9));
//        gc.setFill(Color.BURLYWOOD);
        gc.strokeLine(0,0, getHeight(),getWidth()); // x1, y1, x2, y2
        gc.strokeLine(0,getHeight(), getWidth(),0); // x1, y1, x2, y2
        gc.strokeOval((getWidth()/2)-15,(getHeight()/2)-15, 30,30);
        gc.strokeOval((getWidth()/2)-25,(getHeight()/2)-25, 50,50);
        gc.strokeOval((getWidth()/2)-35,(getHeight()/2)-35, 70,70);
//        for (int i = 10; i < 1000; i=i+10) {
//            gc.strokeOval((getWidth()/2)-(i/2),(getHeight()/2)-(i/2), i,i);
//        }

        // ...
        gc.setStroke(Color.web("#FFA500"));
        gc.setLineDashes(10);
        gc.setLineWidth(5);
        gc.strokeRect(200,50,100,100); // x1, y1, x2, y2
        // ...
        gc.setFill(Color.web("#CD5C5C"));
        gc.fillRect(200,350,100,100); // x1, y1, x2, y2
        // ...
        gc.setFill(new ImagePattern(new Image("newyork.jpg")));
        double[] xpoints = {0, (getWidth()/2), 0};
        double[] ypoints = {0, (getHeight()/2), 500};
        gc.fillPolygon(xpoints, ypoints, xpoints.length);
        // ...
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial",30));
        gc.setEffect(new BoxBlur());
        gc.fillText("Hallo JavaFX",150,30);
    }

}