package be.kdg.ssp.model;

import java.util.Random;

public class SSPEngine {
    private final Random random;

    public SSPEngine() {
        this.random = new Random();
    }

    public Choice play() {
        return Choice.values()[this.random.nextInt(Choice.values().length)];
    }
}
