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

        this.updateView();
    }

    private void updateView() {
        // 4.2 Maak een ObservableList aan van PieChart.Data objecten. Dit kan je doen met behulp van de klassemethode observableArrayList van de klasse FXCollections.
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        // 4.1 Roep de getData methode op van het model om de te tonen gegevens te verkrijgen.
        // 4.3 Doorloop de gegevens die je vanuit het model hebt opgevraagd en voeg voor elke entry uit deze Map een element toe aan je ObservableList:
        for (Map.Entry<String, Double> data : this.model.getData().entrySet()) {
            // 4.4 Gebruik de add methode van ObservableList. Deze methode verwacht telkens een parameter van het type PieChart.Data.
            pieChartData.add(new PieChart.Data(data.getKey(), data.getValue()));
        }

        // 4.5 Gebruik de setData methode van PieChart om je ObservableList door te geven aan je pie chart.
        this.view.getPieChart().setData(pieChartData);

        // 4.6 Zet de titel van je pie chart op “Hoe je de Engels taal leert”.
        this.view.getPieChart().setTitle("Hoe je de Engels taal leert");

    }
}
