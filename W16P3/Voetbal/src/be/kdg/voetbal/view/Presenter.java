package be.kdg.voetbal.view;

import be.kdg.voetbal.model.VoetbalModel;
import javafx.scene.chart.XYChart;

public class Presenter {
    private final VoetbalView view;

    public Presenter(VoetbalView view) {
        this.view = view;

        this.updateView();
    }

    private void updateView() {
        // 4.1 Vraag de X-as van je bar chart op uit de view en geef ze het label “Geboortekwartaal”.
        this.view.getBarChart().getXAxis().setLabel("Geboortekwartaal");

        // 4.2 Maak een nieuwe reeks van gegevens om te tonen in je bar chart. Zo’n reeks van gegevens noemen we een serie. We gaan als volgt tewerk:
        // 4.3 Maak een nieuwe reeks aan om je gegevens in op te slaan.
        XYChart.Series<String, Double> Serie1 = new XYChart.Series<>();

        // 4.4 Zet de naam van je reeks op “Bevolking België”
        Serie1.setName("Bevolking België");

        // 4.5 Voor elk kwartaal uit het model voeg je een nieuw datapunt toe aan je serie:
        for (int i = 0; i < VoetbalModel.KWARTALEN.length; i++) {
            String kwartalen = VoetbalModel.KWARTALEN[i];
            double geboortes_belgie = VoetbalModel.GEBOORTES_BELGIE[i];

            Serie1.getData().add(new XYChart.Data<>(kwartalen, geboortes_belgie));
        }

        // 4.6 Maak een nieuwe (tweede) serie aan en gebruik nu als eerste parameter het kwartaal en als tweede parameter het aantal spelers eerste klasse
        // die geboren zijn in dit kwartaal.
        XYChart.Series<String, Integer> Serie2 = new XYChart.Series<>();

        for (int i = 0; i < VoetbalModel.KWARTALEN.length; i++) {
            String kwartalen = VoetbalModel.KWARTALEN[i];
            int spelers_eerste_klasse = VoetbalModel.SPELERS_EERSTE_KLASSE[i];

            Serie2.getData().add(new XYChart.Data<>(kwartalen, spelers_eerste_klasse));
        }

        // 4.7 Zet de naam van je reeks op “Spelers Eerste Klasse”
        Serie2.setName("Spelers Eerste Klasse");

        // 4.8 Maak een nieuwe (derde) serie aan en gebruik nu als eerste parameter het kwartaal en als tweede parameter het aantal spelers van de nationale
        // selectie die geboren zijn in dit kwartaal.
        XYChart.Series<String, Integer> Serie3 = new XYChart.Series<>();

        for (int i = 0; i < VoetbalModel.KWARTALEN.length; i++) {
            String kwartalen = VoetbalModel.KWARTALEN[i];
            int spelers_nat_selectie = VoetbalModel.SPELERS_NAT_SELECTIE[i];

            Serie3.getData().add(new XYChart.Data<>(kwartalen, spelers_nat_selectie));
        }

        // 4.7 Zet de naam van je reeks op “Spelers Nat Selectie”
        Serie3.setName("Spelers Nat Selectie");

        // 4.8 Voeg alle drie deze series toe aan je bar chart.
        this.view.getBarChart().getData().addAll(Serie1, Serie2, Serie3);
    }
}
