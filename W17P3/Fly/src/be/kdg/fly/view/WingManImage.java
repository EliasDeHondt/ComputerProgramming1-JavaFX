package be.kdg.fly.view;

import javafx.scene.image.Image;

public enum WingManImage {
    FRAME_1(1, -5.0), FRAME_2(2, 0.0), FRAME_3(3, 0.0), FRAME_4(4, 0.0), FRAME_5(5, 15.0);

    private static final String imagePath = "be/kdg/fly/view/images/";

    private final Image image;
    private final int number;
    private final double yOffset;

    WingManImage(int number, double yOffset) {
        this.number = number;
        this.yOffset = yOffset;
        this.image = new Image(imagePath + "wingMan" + this.number + ".png");
    }

    public Image getImage() {
        return this.image;
    }

    public double getyOffset() {
        return this.yOffset;
    }

    /**
     * Returns one of five wing man frames.
     * @param number Should be a number from 1 to 5. This number is NOT zero-indexed!
     * @return The corresponding wing man frames.
     */
    static WingManImage get(int number) {
        for (WingManImage wingManFrame : values()) {
            if (wingManFrame.number == number) {
                return wingManFrame;
            }
        }
        return null;
    }
}
