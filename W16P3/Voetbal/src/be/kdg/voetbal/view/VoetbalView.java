package be.kdg.voetbal.view;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.BorderPane;

public class VoetbalView extends BorderPane {
    // 3.1 Voeg een attribuut van het type BarChart toe aan de klasse VoetbalView.
    private BarChart<String, Number> barChart;

    public VoetbalView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // 3.3 Gebruik de constructor van BarChart die twee parameters heeft, een X-as en een Y-as.
        // De parameters die je meegeeft aan de constructor zijn een nieuwe CategoryAxis (als
        // X-as) en een nieuwe NumberAxis (als Y-as). Voor de assen kan je telkens de default constructor gebruiken.
        CategoryAxis categoryAxis = new CategoryAxis();
        NumberAxis numberAxis = new NumberAxis();
        this.barChart = new BarChart<>(categoryAxis, numberAxis);
    }

    private void layoutNodes() {
        // 3.4 Plaats je attribuut centraal op je BorderPane.
        this.setCenter(this.barChart);
    }

    // 3.2 Schrijf een getter voor dit attribuut. Gebruik de juiste access level!
    BarChart getBarChart() {
        return this.barChart;
    }
}
