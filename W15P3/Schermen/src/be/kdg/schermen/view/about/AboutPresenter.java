package be.kdg.schermen.view.about;

import be.kdg.schermen.model.SimpleModel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AboutPresenter {
    private SimpleModel model;
    private AboutView view;

    public AboutPresenter(SimpleModel model, AboutView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBtnOK().setOnAction(event -> view.getScene().getWindow().hide());
    }

    private void updateView() {
        //Hier niet van toepassing
    }
}
