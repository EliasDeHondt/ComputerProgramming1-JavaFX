package be.kdg.mypaint.model;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class PaintModel {
    private List<Point> points = new ArrayList<>();

    public void addPoint(Point p){
        this.points.add(p);
    }

    public void clear() {
        this.points.clear();
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public void undo() {
        if (!this.points.isEmpty()) {
            this.points.remove(this.points.size()-1);
        }

    }

    public void save() {
        try {
            Formatter formatter = new Formatter("tekening.txt");
            for (Point point : this.points) {
                formatter.format("%d %d %f %f %f %d %n",
                        point.getX(),
                        point.getY(),
                        point.getColor().getRed(),
                        point.getColor().getGreen(),
                        point.getColor().getBlue(),
                        point.getPensize());
            }
            formatter.close();
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("File Handler ERROR");
            alert.setTitle("File Handler ERROR");
            alert.showAndWait();
            throw new RuntimeException(e);
        }
    }

    public void load() {
        try {
            this.points.clear();
            Scanner scanner = new Scanner(new File("tekening.txt"));
            while (scanner.hasNext()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                double red = scanner.nextDouble();
                double green = scanner.nextDouble();
                double blue = scanner.nextDouble();
                int pensize = scanner.nextInt();
                Point point = new Point(x,y, pensize, new Color(red,green,blue,1));
                this.points.add(point);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("File Handler ERROR");
            alert.setTitle("File Handler ERROR");
            alert.showAndWait();
            throw new RuntimeException(e);
        }

    }


}
