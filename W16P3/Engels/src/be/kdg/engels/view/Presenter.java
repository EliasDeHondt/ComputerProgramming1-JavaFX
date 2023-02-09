package be.kdg.engels.view;

import be.kdg.engels.model.EngelsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.Map;

public class Presenter {
    private final EngelsModel model;
    private final EngelsView view;

    public Presenter(EngelsModel model, EngelsView view) {
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
