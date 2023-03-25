package be.kdg.fly.view;

public class FlyPresenter {
    private final FlyPane view;
    private final FlyTransition flyTransition;

    public FlyPresenter(FlyPane view) {
        this.view = view;
        this.flyTransition = new FlyTransition(this.view);
        this.updateView();
    }

    private void updateView() {
        this.flyTransition.play();
    }
}