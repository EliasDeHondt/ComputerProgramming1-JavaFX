package be.kdg.raster.view;

import be.kdg.raster.model.RasterModel;

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
        // Voorlopig geen event handlers.
    }

    private void updateView() {
        this.view.drawRaster(this.model.getRows(), this.model.getColumns());
    }
}
