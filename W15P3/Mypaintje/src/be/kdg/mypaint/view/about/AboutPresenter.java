package be.kdg.mypaint.view.about;

import be.kdg.mypaint.model.PaintModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AboutPresenter {
    private PaintModel model;
    private AboutView view;

    public AboutPresenter(PaintModel model, AboutView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        //TODO ButtonEvent
    }

    private void updateView() {
        //Hier niet van toepassing
    }
}
