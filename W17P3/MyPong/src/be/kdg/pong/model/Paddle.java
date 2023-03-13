package be.kdg.pong.model;

public class Paddle {
    public static final int DEFAULT_HEIGHT = 10;
    public static final int DEFAULT_WIDTH = 60;
    private int x;
    private int y;
    private int w = DEFAULT_WIDTH;
    private int h = DEFAULT_HEIGHT;

    public Paddle() {
        x = (Pong.FIELD_WIDTH + 2) - (this.w / 2);
        y = (Pong.FIELD_HEIGHT - h );
    }

    public void setX(int x) {
        if (x > 0 && x <= (Pong.FIELD_HEIGHT - this.w)) this.x = x;
    }

    public int getX() { // Get..
        return this.x;
    }
    public int getY() { // Get..
        return this.y;
    }
    public int getW() { // Get..
        return this.w;
    }
    public int getH() { // Get..
        return this.h;
    }
}