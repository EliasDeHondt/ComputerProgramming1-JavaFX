package be.kdg.mypaint.model;

import javafx.scene.paint.Color;

public class Point {
    private final int x;
    private final int y;
    private final int pensize;
    private final Color color;

    public Point(int x, int y, int pensize, Color color) {
        this.x = x;
        this.y = y;
        this.pensize = pensize;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPensize() {
        return pensize;
    }

    public Color getColor() {
        return color;
    }
}
