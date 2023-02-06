package view;


import model.Dobbelen;

public class Presenter {
    private Dobbelen model;
    private DobbelenView view;

    public Presenter(Dobbelen model, DobbelenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        //TODO
    }

    private void updateView() {
        //TODO
    }
}
