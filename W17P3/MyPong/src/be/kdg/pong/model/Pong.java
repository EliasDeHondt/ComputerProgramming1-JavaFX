package be.kdg.pong.model;

public class Pong {
    public static final int FIELD_WIDTH = 500;
    public static final int FIELD_HEIGHT = 500;
    private Ball ball;
    private Paddle paddle;
    private int score;
    private boolean lost = false;

    public Pong() {
        this.reset();
    }

    public void update() {
        this.ball.move();
        if (this.ball.getY() >= this.paddle.getY() - (this.ball.getR() * 2)) {
            if (this.ball.getX() >= this.paddle.getX() && this.ball.getX() <= this.paddle.getX() + this.paddle.getH()) {
                this.ball.setStepY(-this.ball.getStepY());
            }
        }
        else if (this.ball.getY() > Pong.FIELD_HEIGHT) {
            this.lost = true;
        }
    }

    public Ball getBall() { // Get..
        return this.ball;
    }
    public Paddle getPaddle() { // Get..
        return this.paddle;
    }
    public int getScore() { // Get..
        return this.score;
    }
    public boolean isLost() {
        return this.lost;
    }
    public void reset() {
        this.ball = new Ball();
        this.paddle = new Paddle();
        this.score = 0;
        this.lost = false;
    }
}