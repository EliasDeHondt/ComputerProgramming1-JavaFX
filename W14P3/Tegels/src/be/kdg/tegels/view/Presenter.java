package be.kdg.tegels.view;

import be.kdg.tegels.model.TileModel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Presenter {
    // 4.0.1 Zorg voor twee attributen: een attribuut voor het model en een attribuut voor de view.
    private final TileModel model;
    private final TileView view;
    // 4.0.2 We hebben twee extra attributen nodig die bijhouden over welke tegel (rij + kolom) de muis beweegt of hangt.
    private int currentHoverColumn;
    private int currentHoverRow;
    public Presenter(TileModel model, TileView view) {
        // Implementeer de constructor: zorg er voor dat het model en de view met behulp van parameters een waarde krijgen. De twee andere attributen
        // (rij + kolom van de huidige tegel) initialiseer je beiden als “-1”, wat betekent dat de muis momenteel niet boven een tegel beweegt of hangt.
        this.model = model;
        this.view = view;

        this.currentHoverColumn = -1;
        this.currentHoverRow = -1;

        this.addEventHandlers();
        this.updateView();
    }
    private int translateXToColumn(final double x) {
        final double width = this.view.getCanvas().getWidth();
        final int columnResult = (int)(x / width * TileModel.COLUMNS);
        if (columnResult >= 0 && columnResult < TileModel.COLUMNS) {
            return columnResult;
        }
        else {
            return -1;
        }
    }
    private int translateYToRow(final double y) {
        final double height = this.view.getCanvas().getHeight();
        final int rowResult = (int)(y / height * TileModel.ROWS);
        if (rowResult >= 0 && rowResult < TileModel.ROWS) {
            return rowResult;
        }
        else {
            return -1;
        }
    }
    private void addEventHandlers() {
        // 4.1.1 Vraag het Canvas op uit de view (getCanvas) en hang drie event handlers aan deze control:
        // setOnMouseMoved wordt opgeroepen wanneer de gebruiker over het Canvas beweegt met de muis.
        this.view.getCanvas().setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // 4.1.2 Als we de X-waarde delen door het aantal kolommen (TileModel.COLUMNS) dan krijgen we een getal van nul tot aantal
                // kolommen – 1… dit getal kunnen we gebruiken als kolom-index!
                int kolomIndex = translateXToColumn(mouseEvent.getX());
                // 4.1.3 Als we de Y-waarde delen door het aantal rijen (TileModel.ROWS) dan krijgen we een getal van nul tot aantal rijen – 1… dit getal
                // kunnen we gebruiken als rij-index!
                int rijIndex = translateYToRow(mouseEvent.getY());
                currentHoverColumn = kolomIndex;
                currentHoverRow = rijIndex;
                updateView();
            }
        });
        // 4.1.4 etOnMouseClicked wordt opgeroepen wanneer de gebruiker op het Canvas klikt met de muis.
        this.view.getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // 4.1.4 Ga opnieuw aan de slag met het MouseEvent. Gebruik dit keer de berekende kolom-index en rij-index om de geselecteerde tegel in het
                //model vast te leggen (setSelectedTile). Je hebt dezelfde berekeningen gedaan als in de vorige event handler. Pas je klasse aan
                // zodat de code voor de berekeningen hergebruikt wordt!
                model.setSelectedTile(currentHoverColumn,currentHoverRow);
                updateView();
            }
        });
        // 4.1.5 etOnMouseExited wordt opgeroepen wanneer de gebruiker het Canvas verlaat met de muis:
        this.view.getCanvas().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // 4.1.6 De attributen voor de huidige rij en kolom worden beiden op “-1” gezet.
                currentHoverColumn = 1;
                currentHoverRow = 1;
                updateView();
            }
        });

    }
    private void updateView() {
        this.view.displayCurrentTiles(currentHoverColumn,currentHoverRow,this.model.getSelectedTileColumn(),this.model.getSelectedTileRow());

    }
}
