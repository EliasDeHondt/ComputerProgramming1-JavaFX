package be.kdg.ssp.view;

import be.kdg.ssp.model.SSPEngine;
import javafx.animation.Transition;
import javafx.util.Duration;

public class SSPTransition extends Transition {
    private final SSPEngine model;
    private final SSPView view;

    public SSPTransition(SSPEngine model, SSPView view) {
        this.model = model;
        this.view = view;

        // Hier aanvullen...
    }

    @Override
    protected void interpolate(double frac) {
        // Hier aanvullen...
    }
}
