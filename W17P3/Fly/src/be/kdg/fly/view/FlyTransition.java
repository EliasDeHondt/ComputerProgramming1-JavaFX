package be.kdg.fly.view;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class FlyTransition extends Transition {
    private final FlyPane view;
    private int previousImageNumber;

    public FlyTransition(FlyPane view) {
        this.view = view;
        this.previousImageNumber = 0; // Starten op 0 zodat er onmiddellijk getekend wordt

        // Hier aanvullen...
    }

    @Override
    protected void interpolate(double frac) {
        // Hier aanvullen...
    }
}
