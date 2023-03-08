package be.kdg.feedthebirds.view;


import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * Demo voor het gebruik van drag/drop.
 * Geen Modelklasse aanwezig; dus enkel View + Presenter
 *
 * Check de tutorial op: https://docs.oracle.com/javase/8/javafx/events-tutorial/drag-drop.htm
 */

public class BirdsPresenter {
    private BirdsView view;
    private Media birdSound;

    public BirdsPresenter(BirdsView view) {
        this.view = view;
        addEventHandlers();
        birdSound = new Media(new File("res/birdSound.m4a").toURI().toString());
    }

    private void addEventHandlers() {
        //1) voeg OnDragDetected EventHandler toe aan de source (imageviews met wormen):
        EventHandler<MouseEvent> dragDetected = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ImageView source = (ImageView) event.getSource();
                //De image wordt in het DragBoard gestopt tijdens de transfer
                Dragboard dragboard = source.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(source.getImage());
                dragboard.setContent(content);
            }
        };
        for (int i = 0; i < 5; i++) {
            view.getImgLeftWorms()[i].setOnDragDetected(dragDetected);
            view.getImgRightWorms()[i].setOnDragDetected(dragDetected);
        }

        //2) voeg OnDragOver EventHandler toe aan het target (imageview met vogelnest)
        //   dit zorgt ervoor dat de target de worm kan accepteren.
        ImageView target = view.getImgBirds();
        target.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != target && event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                event.consume();
            }
        });

        //3) voeg OnDragDropped EventHandler toe aan target
        //   deze wordt uitgevoerd zodra de drop gebeurt.
        //   We spelen een geluidje en geven door dat de drop gelukt is
        target.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {
                    new MediaPlayer(birdSound).play();
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
        //4) voeg OnDragDone EventHandlers toe aan sources (imageviews met wormen)
        //   We verwijderen de image van de worm die versleept werd
        EventHandler<DragEvent> dragDone = new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                ImageView source = (ImageView) event.getSource();
                if (event.getTransferMode() == TransferMode.MOVE) {
                    source.setImage(null);
                }
                event.consume();
            }
        };
        for (int i = 0; i < 5; i++) {
            view.getImgLeftWorms()[i].setOnDragDone(dragDone);
            view.getImgRightWorms()[i].setOnDragDone(dragDone);
        }
    }
}
