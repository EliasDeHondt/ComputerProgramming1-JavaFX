package be.kdg.engels.view;

import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;

public class EngelsView extends BorderPane {
    // 3.1 Voeg een attribuut van het type PieChart toe aan de klasse EngelsView
    private PieChart pieChart;

    public EngelsView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // 3.3 Gebruik de default constructor van PieChart om je attribuut te initialiseren.
        this.pieChart = new PieChart();
    }

    private void layoutNodes() {
        // 3.4 Plaats je attribuut centraal op je BorderPane.
        this.setCenter(this.pieChart);
    }
    // 3.2 Schrijf een getter voor dit attribuut. Gebruik de juiste access level!
    PieChart getPieChart() {
        return this.pieChart;
    }
}
