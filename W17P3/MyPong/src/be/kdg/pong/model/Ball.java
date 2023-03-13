package be.kdg.pong.model;

public class Ball {
    public static final int DEFAULT_RADIUS = 10;
    private int x;
    private int y;
    private final int r = DEFAULT_RADIUS;
    private int stepX = 2;
    private int stepY = 2;

    public Ball() {
        x = Pong.FIELD_HEIGHT/ 2;
        y = Pong.FIELD_WIDTH / 2;
        this.move();
    }

    public void move() {
        x += this.stepX;
        y += this.stepY;

        if (this.x >= Pong.FIELD_WIDTH - (2 * this.r)) { // T R
            this.stepX = -this.stepX;
        }
        else if (this.x <= 0) { // T L
            this.stepX = -this.stepX;
        }
        if (this.y <= 0) { // T B
            this.stepY = -this.stepY;
        }
    }

    public int getX() { // Get..
        return this.x;
    }
    public int getY() { // Get..
        return this.y;
    }
    public int getR() { // Get..
        return this.r;
    }
    public int getStepX() { // Get..
        return this.stepX;
    }
    public void setStepX(int stepX) { // Set..
        this.stepX = stepX;
    }
    public int getStepY() { // Get..
        return this.stepY;
    }
    public void setStepY(int stepY) { // Set..
        this.stepY = stepY;
    }
}