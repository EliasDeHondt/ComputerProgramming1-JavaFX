package be.kdg.ssp.view;

import be.kdg.ssp.model.Choice;
import be.kdg.ssp.model.SSPEngine;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class SSPTransition extends Transition {
    private final SSPEngine model;
    private final SSPView view;

    public SSPTransition(SSPEngine model, SSPView view) {
        this.model = model;
        this.view = view;

        // 4.1 Zorg er voor dat een cyclus drie seconden duurt.
        setCycleDuration(Duration.seconds(3));

        // 4.2 Voeg een event handler toe die aan het einde van de animatie opgeroepen wordt. De methode die hiervoor nodig hebben is setOnFinished.
        setOnFinished(actionEvent -> {
            // 4.3 Voer de play methode uit van het model. Deze geeft een willekeurig Choice object terug dat we moeten tonen in het tekstveld van de view.
            Choice choice = this.model.play();

            // 4.4 Haal het tekstveld op uit de view en geef dit tekstveld de juiste tekst (setText).
            this.view.getTextField().setText(choice.toString());

            // 4.5 Zet de kleur van het tekstveld van de view op SSPView.STANDARD_COLOR. (methode setTextFill).
            this.view.getTextField().setTextFill(SSPView.STANDARD_COLOR);

            // 4.6 Zorg er voor dat de knop van de view niet disabled is.
            this.view.getPlayButton().setDisable(false);
        });
    }

    @Override
    protected void interpolate(double frac) {
        // 5.7 In deze methode passen we de tekst aan van het tekstveld van de view. We kijken hiervoor naar de parameter genaamd frac.
        if (frac >= 0.0 & frac < 0.33) {
            this.view.getTextField().setText("3");
        } else if (frac >= 0.33 & frac < 0.66) {
            this.view.getTextField().setText("2");
        } else if (frac >= 0.66 & frac <= 1.0) {
            this.view.getTextField().setText("1");
        }
        // Of :-)
        // this.view.getTextField().setText(frac >= 0.0 && frac < 0.33 ? "3" : frac >= 0.33 && frac < 0.66 ? "2" : "1");
    }
}
