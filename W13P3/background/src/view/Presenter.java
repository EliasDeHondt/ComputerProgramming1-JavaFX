package view;

import be.kdg.background.model.Kleuren;

public class Presenter {
    private Kleuren model;
    private View view;

    public Presenter(Kleuren model, View view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        // TODO
    }

    private void updateView() {
        // TODO
    }
}
