package be.kdg.wtc.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Presenter {
    private final WTCView view;

    public Presenter(WTCView view) {
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        this.view.getSlider().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                updateView();
            }
        });
    }

    private void updateView() {
        this.view.updateCanvas(this.view.getSlider().getValue());
    }
}
