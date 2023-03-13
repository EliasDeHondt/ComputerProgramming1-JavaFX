package be.kdg.stopwatch.model;

public class StopwatchModel {
    private static final int START_TICK_DURATION_MILLIS = 1000;
    private int hours;
    private int minutes;
    private int seconds;
    private int tickDurationMillis;

    public StopwatchModel() {
        this.tickDurationMillis = START_TICK_DURATION_MILLIS;
    }

    public void tick() {
        this.seconds++;
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes++;
            if (this.minutes == 60) {
                this.minutes = 0;
                this.hours++;
            }
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void reset() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        if(this.tickDurationMillis > 100) {
            this.tickDurationMillis -= 100; //versnelling
        }
    }

    public int getTickDurationMillis() {
        return tickDurationMillis;
    }
}
