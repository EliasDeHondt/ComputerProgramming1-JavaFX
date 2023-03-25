package be.kdg.fly.view;

import javafx.animation.Animation;
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

        // 4.1 Een cyclus moet 450 milliseconden duren.
        setCycleDuration(Duration.millis(450));

        // 4.2 Er zijn oneindig veel cycli in deze Transition.
        setCycleCount(Animation.INDEFINITE);

        // 4.3 Een cyclus moet aan het einde automatisch teruggespoeld worden (achterstevoren afspelen).
        setAutoReverse(true);

        // 4.4 Zorg voor een lineaire interpolatie. (methode setInterpolator).
        setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double frac) {
        // 4.5 In deze methode bepalen we de te tonen Image voor de ImageView van de view. We kijken hiervoor naar de parameter genaamd frac.
//        int imageNumber = 0;
//
//        if (frac >= 0.0 & frac < 0.2) {
//            imageNumber = 1;
//
//        } else if (frac >= 0.2 & frac < 0.4) {
//            imageNumber = 2;
//
//        } else if (frac >= 0.4 & frac < 0.6) {
//            imageNumber = 3;
//
//        } else if (frac >= 0.6 & frac < 0.8) {
//            imageNumber = 4;
//
//        } else if (frac >= 0.8 & frac <= 1) {
//            imageNumber = 5;
//
//        }
        // OF dit is op de slimmere manier :-)
        int imageNumber = 0;
        double interval = 0.2;

        switch ((int) Math.floor(frac / interval)) {
            case 0 -> imageNumber = 1;
            case 1 -> imageNumber = 2;
            case 2 -> imageNumber = 3;
            case 3 -> imageNumber = 4;
            case 4 -> imageNumber = 5;
            default -> {
            }
        }

        // 4.6 We hoeven natuurlijk enkel het Canvas aan te passen indien het huidige frame nummer verschillend is van het vorige frame nummer.
        // Indien dit het geval is voer je volgende stappen uit:
        if (this.previousImageNumber != imageNumber) {
            // 4.7 Bepaal de juiste WingManImage met behulp van variabele frac. Sla deze op in een lokale variabele.
            WingManImage wingManImage;
            wingManImage = WingManImage.get(imageNumber);

            // 4.8 Sla de breedte en hoogte van de te tonen Image op in lokale variabelen.
            double breedteImage = wingManImage.getImage().getWidth();
            double hoogteImage = wingManImage.getImage().getHeight();

            // 4.9 Sla de breedte en hoogte van het Canvas (zie view) op in lokale variabelen.
            double breedteCanvas = this.view.getCanvas().getWidth();
            double hoogteCanvas = this.view.getCanvas().getHeight();

            // 4.10 Geef het volledige Canvas een blauwe achtergrond.
            this.view.getCanvas().setStyle("-fx-background-color: #0000FF");

            // 4.11 Toon het Image centraal op het Canvas van de view. Voor een optimaal effect kan je bij de Y-coördinaat de waarde getYOffset
            // (methode van WingManFrame) bijtellen zodat de beweging vlot oogt.
            double yOffset = wingManImage.getyOffset();

            GraphicsContext gc = this.view.getCanvas().getGraphicsContext2D();

            gc.clearRect(0,0, breedteCanvas, hoogteCanvas);
            gc.drawImage(wingManImage.getImage(), (breedteCanvas - breedteImage) / 2, (hoogteCanvas - hoogteImage) / 2 + yOffset);

            this.previousImageNumber = imageNumber;
        }
    }
}
