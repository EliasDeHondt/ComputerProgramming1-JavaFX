package be.kdg.schermen.view.game;

import javafx.geometry.Side;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {
    private MenuItem miAbout;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        miAbout = new MenuItem("About");
    }

    private void layoutNodes() {
        // Menu bovenaan:
        Menu mnHelp = new Menu("Help");
        mnHelp.getItems().addAll(miAbout);
        MenuBar menuBar = new MenuBar(mnHelp);
        setTop(menuBar);

        // Afbeelding in Center:
        this.setBackground(new Background(
                new BackgroundImage(new Image("ganzenbord.jpg"),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0.0, false,
                                Side.BOTTOM, 0.0, false),
                        BackgroundSize.DEFAULT
                )));
        setCenter(new Canvas(480, 340));
    }

    MenuItem getMiAbout() {
        return miAbout;
    }
}
