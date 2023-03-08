package be.kdg.feedthebirds.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class BirdsView extends BorderPane {
    private ImageView imgBirds;
    private ImageView[] imgLeftWorms = new ImageView[5];
    private ImageView[] imgRightWorms = new ImageView[5];

    public BirdsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        imgBirds = new ImageView(new Image("birds.gif"));
        for (int i=0;i<5;i++) {
            imgLeftWorms[i] = new ImageView(new Image("worm.gif"));
            imgRightWorms[i] = new ImageView(new Image("worm.gif"));
        }
    }

    private void layoutNodes() {
        VBox leftPane = new VBox(imgLeftWorms);
        leftPane.setSpacing(20);
        VBox rightPane = new VBox(imgRightWorms);
        rightPane.setSpacing(20);
        for (int i=0;i<5;i++) {
            VBox.setMargin(imgLeftWorms[i],new Insets(20));
            VBox.setMargin(imgRightWorms[i],new Insets(20));
        }
        setLeft(leftPane);
        setRight(rightPane);
        setCenter(imgBirds);
        setStyle("-fx-background-image: url(trees.jpg);");
    }

    ImageView getImgBirds() {
        return imgBirds;
    }

    ImageView[] getImgLeftWorms() {
        return imgLeftWorms;
    }

    ImageView[] getImgRightWorms() {
        return imgRightWorms;
    }
}
