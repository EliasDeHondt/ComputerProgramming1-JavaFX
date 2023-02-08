package be.kdg.background.view;

import be.kdg.background.model.Kleuren;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class Presenter {
    // Attributes
    private Kleuren model;
    private View view;
    // Constructors
    public Presenter(Kleuren model, View view) {
        this.model = model;
        this.view = view;
        this.view.setStyle("-fx-background-color: #FFFFFF");
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        // 4.1.1 Hang een eventhandler aan de knop. Om dit te kunnen doen moet je ervoor zorgen dat de button bereikbaar is via een getter die
        // je aan de klasse View toevoegt (packageprivate).
        this.view.getChangeButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    // 4.1.2 Zorg er voor dat de eventhandler de methode updateView (zie punt 4.2) oproept.
                    updateView();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Ik heb geen zin! :)");
                    alert.setTitle("ERROR");
                    alert.showAndWait();
                }
            }
        });
    }
    private void updateView() {
        // 4.2.1 Bij het klikken op de "Change Colour" Button moet je de achtergrondkleur van de view aanpassen door uit het model
        // een bepaalde kleur op te halen. Via de setStyle methode die je op de view toepast kan je de kleur aanpassen.
        this.view.setStyle(this.model.getBackgroundColour());
    }
}
