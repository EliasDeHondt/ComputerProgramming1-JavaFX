package be.kdg.mywoordle.view;

import be.kdg.mywoordle.model.Evaluatie;
import be.kdg.mywoordle.model.Woordle;
import be.kdg.mywoordle.model.WoordleException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

import java.awt.font.TextHitInfo;

/**
 * Presenter die de verbinding verzorgt tussen Viewklassen en modelklasse Woordle
 */
public class WoordlePresenter {
    private Woordle model;
    private WoordleView view;

    public WoordlePresenter(Woordle model, WoordleView view) {
        this.model = model;
        this.view = view;
        handleEvents();
    }

    private void handleEvents() {
        view.getBtnBevestig().setOnAction(actionEvent -> {
            try {
                updateView(model.evalueer(view.getTxtInput().getText()));
            } catch (WoordleException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.setTitle("Woordle Exception");
                alert.showAndWait();
                view.getTxtInput().clear();
                view.getTxtInput().requestFocus();
            }
        });
    }

    private void updateView(Evaluatie[] evaluaties) {
        String poging = view.getTxtInput().getText().toUpperCase();
        int beurt = model.getBeurtenTeller();
        for (int i = 0; i < evaluaties.length; i++) {
            WoordleTextField tf = view.getWoordleRows()[beurt - 1].getTxtFields()[i];
            tf.setText(poging.charAt(i));
            switch (evaluaties[i]) {
                case JUIST -> tf.setBackground(Color.LIMEGREEN);
                case FOUTE_PLEK -> tf.setBackground(Color.GOLD);
                case FOUT -> tf.setBackground(Color.GREY);
            }
        }
        if (!model.isSpelGedaan()) {
            view.getLblBeurt().setText("Beurt " + (beurt + 1) + ":");
            view.getTxtInput().clear();
            view.getTxtInput().requestFocus();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("EINDE");
            alert.setHeaderText("Het spel is gedaan");
            if (model.isWoordGevonden()) {
                alert.setContentText("Proficiat; gevonden in " + model.getBeurtenTeller() + " beurten!");
            } else {
                alert.setContentText("Alle beschikbare beurten zijn opgebruikt!");
            }
            alert.showAndWait();
            view.getBtnBevestig().setDisable(true);
        }
    }
}
