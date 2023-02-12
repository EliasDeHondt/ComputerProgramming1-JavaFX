package be.kdg.raster.view;

import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.awt.*;

public class RasterView extends BorderPane {
    // 3.0 Maak een attribuut aan van het type Canvas.
    private Canvas canvas;
    // 5.1.1 Voeg vier controls toe (twee labels en twee sliders)
    private TextField rijenT;
    private TextField kolommenT;
    private Slider rijenS;
    private Slider kolommenS;
    public RasterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // 3.1 Initialiseer je Canvas attribuut zodat de breedte 640 pixels is en de hoogte 400 pixels. Gebruik hiervoor de juiste constructor van de Canvas klasse.
        this.canvas = new Canvas(640,400);
        // 5.1.1 Voeg vier controls toe (twee labels en twee sliders)
        this.rijenT = new TextField("Rijen");
        this.rijenS = new Slider();
        this.kolommenT = new TextField("Kolommen");
        this.kolommenS = new Slider();
    }

    private void layoutNodes() {
        this.rijenS.setShowTickMarks(true);
        this.kolommenS.setShowTickMarks(true);
        this.rijenS.setShowTickLabels(true);
        this.kolommenS.setShowTickLabels(true);
        this.rijenT.setEditable(false);
        this.kolommenT.setEditable(false);
        // 3.2 Plaats je Canvas in het centrum van deze BorderPane.
        setCenter(this.canvas);
        // 5.1.2 Plaats de controls op de view.
        VBox bottom = new VBox();
        bottom.getChildren().addAll(this.rijenT,this.rijenS,this.kolommenT,this.kolommenS);
        setBottom(bottom);
    }

    // 3.3 Deze methode heeft twee parameters: het aantal rijen en het aantal kolommen.
    void drawRaster(int rij, int kolom) {
        // 3.3.1 Haal de GraphicsContext op uit je Canvas en maak alvast volgende lokale variabelen aan die het rekenwerk kunnen vergemakkelijken:
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        // 3.3.2 De breedte van je Canvas kan je opvragen uit je Canvas.
        double breedte = this.canvas.getWidth();
        // 3.3.3 De hoogte van je Canvas kan je eveneens opvragen
        double hoogte = this.canvas.getHeight();
        // 3.3.4 De rij-hoogte kan je berekenen door de totale hoogte de delen door het aantal rijen
        double rijHoogte = hoogte/rij;
        // 3.3.5 De kolom-breedte kan je berekenen door de totale breedte te delen door het aantal kolommen
        double kolomBreedte = breedte/kolom;
        // 5.1.3 Je moet deze methode aanpassen zodat het volledige Canvas wit wordt gekleurd. Dit moet gebeuren vóór dat je de lijnen tekent.
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,breedte,kolomBreedte*kolom);
        // 3.3.6 Teken de lijnen tussen de rijen zodat de rijen de zichtbaar worden:
        // Om de twee punten (x1, y1) en (x2, y2) te bepalen zal je de eerder berekende rij-hoogte nodig hebben alsook de totale breedte.
        for (int i = 0; i < rij - 1; i++) {
            double y1 = (i + 1) * rijHoogte;
            double x1 = 0;
            double x2 = canvas.getWidth();
            gc.strokeLine(x1, y1, x2, y1);
        }
        // 3.3.7 Teken de lijnen tussen de kolommen zodat de kolommen zichtbaar worden:
        // Om de twee punten (x1, y1) en (x2, y2) te bepalen zal je de eerder berekende kolom-breedte nodig hebben alsook de totale hoogte…
        for (int i = 0; i < kolom - 1; i++) {
            double x1 = (i + 1) * kolomBreedte;
            double y1 = 0;
            double y2 = canvas.getHeight();
            gc.strokeLine(x1, y1, x1, y2);
        }
    }
    public Slider getRijenS() { // Get..
        return this.rijenS;
    }

    public Slider getKolommenS() { // Get..
        return this.kolommenS;
    }
}
