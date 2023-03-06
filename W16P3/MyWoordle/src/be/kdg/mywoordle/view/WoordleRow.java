package be.kdg.mywoordle.view;

import be.kdg.mywoordle.model.Woord;
import javafx.scene.layout.GridPane;

/**
 * Onderdeel van WoordleView
 */
public class WoordleRow extends GridPane {
    private WoordleTextField[] txtFields;

    public WoordleRow() {
        txtFields = new WoordleTextField[Woord.WOORD_LENGTE];
        for (int i = 0; i < Woord.WOORD_LENGTE; i++) {
            txtFields[i] = new WoordleTextField();
            super.add(txtFields[i], i, 0);
        }
        setHgap(6);
    }

    WoordleTextField[] getTxtFields() {
        return txtFields;
    }
}
