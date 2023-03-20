package be.kdg.view;

import be.kdg.model.SpelModel;
import javafx.scene.control.Alert;

import java.io.IOException;

public class SettingsPresenter {
    private final SpelModel model;
    private final SettingsView view;
    private boolean settingsChanged = false;

    public SettingsPresenter(SpelModel model, SettingsView view) {
        this.model = model;
        this.view = view;
        updateView();
        leesSettings();
        addEventHandlers();
    }

    private void addEventHandlers()  {
        this.view.getSaveButton().setOnAction(event -> {
            this.model.setNaam(this.view.getNaamField().getText());
            this.model.setLevel(Integer.parseInt(this.view.getLevelField().getText()));
        });

        this.view.getScene().getWindow().setOnCloseRequest(windowEvent -> {
            try {
                this.model.saveSettings();

            } catch (IOException e) {
                showAlert(e,"Schrijven");
            }

        });

    }

    private void updateView() {
        this.view.getNaamField().setText(this.model.getNaam());
        this.view.getLevelField().setText(String.valueOf(this.model.getLevel()));
    }

    private void leesSettings() {

        try {
            this.model.readSettings();

        } catch (IOException e) {
            showAlert(e, "Lezen");
        }

    }

    private void showAlert(IOException e, String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(String.format("%s Settings ERROR", title));
        alert.setHeaderText(e.getMessage());
        alert.showAndWait();
    }

}

