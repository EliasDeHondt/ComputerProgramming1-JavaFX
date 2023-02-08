package be.kdg.pensioen.view;


import be.kdg.pensioen.model.Pensioen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class PensioenPresenter {
    // Attributes
    private Pensioen model;
    private PensioenView view;
    // Constructors
    public PensioenPresenter(Pensioen model, PensioenView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
    }
    // Methods
    private void addEventHandlers() {
        // 4.1.1 Hang een eventhandler aan de knop. Om dit te kunnen doen moet je ervoor zorgen dat de button bereikbaar is
        // via een getter die je aan de klasse PensioenView toevoegt (package-private).
        this.view.getBerekenButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    // Zorg er voor dat de eventhandler de methode updateView (zie punt 4.2) oproept.
                    model.setGeboorteJaar(Integer.parseInt(view.getGeboorteJaarField().getText()));
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
        // 4.2.1 Bij het klikken op de "Bereken" Button moet je de view aanpassen door uit het model het pensioenjaar op te halen.
        // Zorg ervoor dat beide TextField via een getter in de klasse PensioenView bereikbaar zijn.
        this.view.setDataField(String.valueOf(this.model.getPensioenJaar()));

    }
}
