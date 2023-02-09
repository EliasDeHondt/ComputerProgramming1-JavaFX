package be.kdg.tijd.view;

import be.kdg.tijd.model.TimeModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.time.LocalTime;

public class Presenter {
    // 4.0.1 Zorg voor twee attributen: een attribuut voor het model en een attribuut voor de view.
    private TimeModel model;
    private TimeView view;
    // 4.0.2 Implementeer de constructor: zorg er voor dat beide attributen van een waarde worden voorzien. Hiervoor gebruiken we twee parameters.
    public Presenter(TimeModel model, TimeView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
        // 4.1.1 Hang een event handler aan de slider die je ophaalt uit de view (getSlider).
        // 4.1.2 We willen dat onze event handler opgeroepen wordt wanneer de gebruiker met de muis de slider versleept,
        // dus we werken met setOnMouseDragged en niet met setOnAction!
        this.view.getSlider().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // 4.1.3 Haalt de huidige waarde van de slider op (getValue). De huidige waarde wordt teruggegeven als een kommagetal dat we als volgt interpreteren.
                // Gedeelte vóór de komma zijn uren.
                // Gedeelte na de komma zijn minuten.
                // 9.5  9 uur 30 minuten
                // 13.1  13 uur 6 minuten
                // 16.9  16 uur 54 minuten
                double tijd = view.getSlider().getValue();
                int hours = (int) tijd;
                int minutes = (int) ((tijd - hours) * 60);
                //System.out.printf("\n%d uur %d minuten", hours, minutes);
                LocalTime localTime = LocalTime.of(hours, minutes);
                model.setCurrentTime(localTime);
                updateView();
            }
        });
    }
    private void updateView() {
        // 4.2.1 Roep de methode applyDaylightSun op van de view. Deze methode verwacht drie parameters die je uit het model kan ophalen.
        // Roep de bestaande methodes op van het model: getDaylightPercentage, getSunHeight en getSunPositionX.
        this.view.applyDaylightSun(this.model.getDaylightPercentage(),this.model.getSunHeight(),this.model.getSunPositionX());
        // 4.2.2 Vraag de huidige tijd op uit het model en geef de slider de juiste waarde (setValue). We gebruiken dezelfde regeld als in 4.1:
        LocalTime localTime = this.model.getCurrentTime();
        int hours = localTime.getHour();
        int minutes = localTime.getMinute();
        System.out.printf("\n%d uur %d minuten", hours, minutes); // Extra
        this.view.getSlider().setValue(hours + (double) minutes / 60);

    }
}
