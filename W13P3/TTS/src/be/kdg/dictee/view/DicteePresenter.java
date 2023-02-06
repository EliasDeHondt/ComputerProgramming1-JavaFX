package be.kdg.dictee.view;

import be.kdg.dictee.model.Dictee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Van Elias De Hondt
 * 6/02/2023
 */
public class DicteePresenter {
    // Attributes
    private Dictee dictee;
    private DicteeView dicteeView;

    // Constructors
    public DicteePresenter(Dictee dictee, DicteeView dicteeView) {
        this.dictee = dictee;
        this.dicteeView = dicteeView;
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() { // Event
        dicteeView.getBtnLeesVoor().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String text = dicteeView.getTxtDictee().getText();
                dictee.setTekst(text);
                dictee.leesVoor();
            }
        });
    }
    private void updateView() {
        // Geen update nodeg

    }

}
// Alert alert = new Alert(Alert.AlertType.INFORMATION);
// alert.setHeaderText("Ik heb geen zin!");
// alert.setTitle("Dictee");
// alert.showAndWait();
