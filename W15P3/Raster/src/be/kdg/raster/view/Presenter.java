package be.kdg.raster.view;

import be.kdg.raster.model.RasterModel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Presenter {
    private final RasterModel model;
    private final RasterView view;

    public Presenter(RasterModel model, RasterView view) {
        this.model = model;
        this.view = view;

        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        this.view.getRijenS().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // 5.2.1 haal de waarde op uit de Slider en gebruik de methode setRows van het model om het aantal rijen in te stellen.
                model.setRows((int)view.getRijenS().getValue());
                // 5.2.2 Roep de methode updateView op.
                updateView();
            }
        });
        this.view.getKolommenS().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // 5.2.3 haal de waarde op uit de Slider en gebruik de methode setColumns van het model om het aantal kolommen in te stellen.
                model.setColumns((int)view.getKolommenS().getValue());
                // 5.2.4 Roep de methode updateView op.
                updateView();
            }
        });
    }

    private void updateView() {
        this.view.drawRaster(this.model.getRows(), this.model.getColumns());
    }
}
