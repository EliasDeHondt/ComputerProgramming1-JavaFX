package be.kdg.stadhuis.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Presenter {
    private final StadhuisPane view;
    public Presenter(StadhuisPane view) {
        this.view = view;
        this.addEventHandlers();
    }
    private void addEventHandlers() {
        // 4.1.1 Zorg voor een event handler voor elke radio button. Afhankelijk van de knop moet de juiste methode van StadhuisPane opgeroepen worden.
        this.view.getNormal().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // 3.3 Deze methode zal opgeroepen worden door de presenter. Volgend stuk code zorgt voor een normale weergave van de afbeelding.
                view.resetEffect();
            }
        });
        this.view.getBlackAndWhite().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // 3.4 Deze methode zal opgeroepen worden door de presenter. Volgend stuk code zorgt voor een zwart-wit weergave van de afbeelding.
                view.applyBlackAndWhiteEffect();
            }
        });
        this.view.getSepia().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // 3.5 Deze methode zal opgeroepen worden door de presenter. Volgend stuk code zorgt voor een sepia weergave van de afbeelding.
                view.applySepiaEffect();
            }
        });
    }
}
