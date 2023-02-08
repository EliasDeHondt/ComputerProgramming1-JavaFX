package be.kdg.scramble.view;

import be.kdg.scramble.model.Scrambler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Presenter {
    // Attributes
    // 2.1 Maak twee attributen: het model en de view.
    Scrambler model;
    ScramblerView view;
    // Constructors
    public Presenter(Scrambler model, ScramblerView view) {
        // 2.2 Schrijf een constructor om beide attributen van een waarde te voorzien
        this.model = model;
        this.view = view;
        this.handleEvents();
    }
    // Methods
    // 4.1 Voeg de methode handleEvents toe aan de klasse Presenter en roep ze op in de constructor. Vul de methode in als volgt:
    public void handleEvents() {
        // 4.1.1 Hang een eventhandler aan de knop. Om dit te kunnen doen moet je er voor zorgen dat de button bereikbaar is via een getter die
        // je aan de klasse ScramblerView toevoegt (package-private).
        this.view.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // 4.1.2 Zorg er voor dat de eventhandler de methode updateView (zie punt 4.2) oproept.
                updateView();
            }
        });
    }
    public void updateView() {
        // 4.2.1 Je laat het model een bewerking uitvoeren door de juiste methode van de klasse Scrambler op te roepen.
        this.model.setTekst(this.view.getTextField().getText());
        this.model.scramble();
        // 4.2.2 Je haalt de nodige informatie op uit het model en toont deze in het tekstveld. Je moet er voor zorgen dat het tekstveld,
        // net zoals de knop, bereikbaar is via een getter die je aan ScramblerView toevoegt.
        this.view.getTextField().setText(this.model.getTekst());
    }
}
