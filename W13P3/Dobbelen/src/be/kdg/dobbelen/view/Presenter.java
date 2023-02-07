package be.kdg.dobbelen.view;


import be.kdg.dobbelen.model.Dobbelen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Presenter {
    // Attributes
    private Dobbelen model;
    private DobbelenView view;
    // Constructors
    public Presenter(Dobbelen model, DobbelenView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        // 4.1.1 Hang een eventhandler aan de knop. Om dit te kunnen doen moet je ervoor zorgen dat de button bereikbaar is via een getter die je aan de klasse
        // DobbelenView toevoegt (package-private).
        view.getButWerp().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // 4.1.2 Zorg er voor dat de eventhandler de methode updateView (zie punt 4.2) oproept.
                model.werp();
                updateView();
            }
        });
    }
    private void updateView() {
        switch (model.getAantalOgen1()) {
            // 4.2.1 Je haalt het aantal ogen op voor beide teerlingen. Gebruik de juiste methode van de klasse Dobbelen.
            // 4.2.2 Je toont de overeenkomstige images in de imageviews in de DobbelenView klasse. Je moet er voor zorgen dat de imageviews,
            // net zoals de knop, bereikbaar zijn via getters die je aan DobbelenView toevoegt.
            case 1 -> this.view.setImgDobel1("be\\kdg\\dobbelen\\view\\images\\die1.png");
            case 2 -> this.view.setImgDobel1("be\\kdg\\dobbelen\\view\\images\\die2.png");
            case 3 -> this.view.setImgDobel1("be\\kdg\\dobbelen\\view\\images\\die3.png");
            case 4 -> this.view.setImgDobel1("be\\kdg\\dobbelen\\view\\images\\die4.png");
            case 5 -> this.view.setImgDobel1("be\\kdg\\dobbelen\\view\\images\\die5.png");
            case 6 -> this.view.setImgDobel1("be\\kdg\\dobbelen\\view\\images\\die6.png");
        }
        switch (model.getAantalOgen2()) {
            case 1 -> this.view.setImgDobel2("be\\kdg\\dobbelen\\view\\images\\die1.png");
            case 2 -> this.view.setImgDobel2("be\\kdg\\dobbelen\\view\\images\\die2.png");
            case 3 -> this.view.setImgDobel2("be\\kdg\\dobbelen\\view\\images\\die3.png");
            case 4 -> this.view.setImgDobel2("be\\kdg\\dobbelen\\view\\images\\die4.png");
            case 5 -> this.view.setImgDobel2("be\\kdg\\dobbelen\\view\\images\\die5.png");
            case 6 -> this.view.setImgDobel2("be\\kdg\\dobbelen\\view\\images\\die6.png");
        }
    }
}
