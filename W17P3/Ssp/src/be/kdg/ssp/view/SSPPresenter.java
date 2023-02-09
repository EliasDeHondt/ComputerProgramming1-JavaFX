package be.kdg.ssp.view;

import be.kdg.ssp.model.SSPEngine;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SSPPresenter {
    private final SSPEngine model;
    private final SSPView view;

    public SSPPresenter(SSPEngine model, SSPView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        //this.updateView();
    }

    private void addEventHandlers() {
        this.view.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SSPPresenter.this.view.getPlayButton().setDisable(true);
                SSPPresenter.this.view.getTextField().setTextFill(SSPView.COUNTDOWN_COLOR);

                final Transition transition = new SSPTransition(SSPPresenter.this.model, SSPPresenter.this.view);
                transition.play();
            }
        });
    }

    /*private void updateView() {
    }*/
}
