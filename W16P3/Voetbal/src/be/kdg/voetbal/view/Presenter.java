package be.kdg.voetbal.view;

import be.kdg.voetbal.model.VoetbalModel;
import javafx.scene.chart.XYChart;

public class Presenter {
    private final VoetbalModel model;
    private final VoetbalView view;

    public Presenter(VoetbalModel model, VoetbalView view) {
        this.model = model;
        this.view = view;

        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
    }

    private void updateView() {

    }
}
