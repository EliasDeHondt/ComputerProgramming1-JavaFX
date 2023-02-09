package be.kdg.fly.view;

public class FlyPresenter {
    private final FlyPane view;
    private final FlyTransition flyTransition;

    public FlyPresenter(FlyPane view) {
        this.view = view;
        this.flyTransition = new FlyTransition(this.view);
        //this.addEventHandlers();
        this.updateView();
    }

    /*private void addEventHandlers() {
    }*/

    private void updateView() {
        this.flyTransition.play();
    }
}
