package be.kdg.stopwatch.view;

import be.kdg.stopwatch.model.StopwatchModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class StopwatchPresenter {
    private final StopwatchModel model;
    private final StopwatchView view;

    private Timeline stopwatchTimeline;

    public StopwatchPresenter(StopwatchModel model, StopwatchView view) {
        this.model = model;
        this.view = view;

        setupTimeline();
        addEventhandlers();
        updateView();
    }

/*
    //Basis-opstelling: constante snelheid
    private void setupTimelineBasis() {
        stopwatchTimeline = new Timeline(new KeyFrame(
                Duration.millis(this.model.getTickDurationMillis()), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        model.tick();
                        updateView();
                    }
                }));
        stopwatchTimeline.setCycleCount(Animation.INDEFINITE);
    }
 */


    private void setupTimeline() {
        stopwatchTimeline = new Timeline();
        stopwatchTimeline.setCycleCount(Animation.INDEFINITE);
        updateClockSpeed();
    }

    private void updateClockSpeed() {
        stopwatchTimeline.getKeyFrames().clear();
        stopwatchTimeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(this.model.getTickDurationMillis()), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.tick();
                updateView();
            }
        }));
    }

    private void addEventhandlers() {
        this.view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stopwatchTimeline.play();
            }
        });

        this.view.getBtnPause().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stopwatchTimeline.pause();
            }
        });

        this.view.getBtnStop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stopwatchTimeline.stop();
                model.reset(); // daar wordt de tickDuration aangepast
                updateView();
                updateClockSpeed();
            }
        });
    }

    private void updateView() {
        this.view.getLblHours().setText(String.format("%02d", this.model.getHours()));
        this.view.getLblMinutes().setText(String.format("%02d", this.model.getMinutes()));
        this.view.getLblSeconds().setText(String.format("%02d", this.model.getSeconds()));
    }
}
