package be.kdg.mypaint.model;

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
        points.add(p);
    }

    public void clear() {
        points.clear();
    }

    public List<Point> getPoints() {
        return points;
    }

    //TODO: maak methode undo

    //TODO: methode save

    //TODO: methode load


}
